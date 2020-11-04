package com.ly.commons.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ly.commons.consts.Consts;
import com.ly.commons.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName JwtUtils
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@Slf4j
public class JwtUtils
{
    public static Algorithm algorithm = Algorithm.HMAC512(Consts.PRIVATE_KEY);

    public static final String ISSUSER = "auth0";
    public static final int EXP_MILL = 86400000;

    /**
     *  生成token
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    public static String createToken(String claimJson){
        //利用jwt生成token
        String token = JWT.create()
                .withIssuer(ISSUSER)//jwt的签发者
                .withIssuedAt(new Date())//生成token的时间
                .withExpiresAt(new Date(System.currentTimeMillis()+EXP_MILL))//token的过期时间
                .withClaim("user" , claimJson)//需要在playload中存储的用户信息
                .sign(algorithm);
        return token;
    }
    /**
     *  从请求头中取得token，然后验证有效性，并且解析返回用户对象
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    public static UserDTO loginedUserIdByToken(){
        /* 从当前线程中取得request对象 */
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        /* 从request的头信息中取得token */
        String token = request.getHeader("token");
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
        try
        {
            /* 验证token有效性 */
            verifier.verify(token);
            String playload = token.substring(token.indexOf(".") + 1 , token.lastIndexOf("."));
            playload = new String(Base64.getDecoder().decode(playload));
            Map map = (Map) JSON.parse(playload);
            String userJson = map.get("user").toString();
            UserDTO userDTO = JSON.parseObject(userJson , UserDTO.class);
            return userDTO;
        } catch (JWTVerificationException e){
            log.error("token有效性出现异常" , e);
            throw e;
        }
    }

    public static void main(String[] args) {

        String str = "eyJpc3MiOiJhdXRoMCIsImV4cCI6MTU4Njc0NDkxOCwiaWF0IjoxNTg2NzQ0OTE2LCJ1c2VyIjoie2lkOjEsbmFtZTpcImJkcW5cIn0ifQ";
        DecodedJWT decodedJWT = JWT.decode(str);
        decodedJWT.getClaim("user");

        String playload = new String(Base64.getDecoder().decode(str));
        Map map = (Map) JSON.parse(playload);
        System.out.println(map);

    }
}
