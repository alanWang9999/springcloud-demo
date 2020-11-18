import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @ClassName TestJWT
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
public class TestJWT
{
    public static String JWT_SECRET = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApj6p3WjKxbwfYfnl/7rs1VlfDATRSZ+4GkxVPzKXfI7rAsbKP2R24UE1GIWJN1VXGaKIaW5ZOUVcCw8c6YL6I5uQOo1Xfjz8ArvOJIS8TkaET4l/YH71KzaJOysosRVo9Q8hxWqo2rCcM0PQ5nGaBHjH3df9IvVmsMxywwknh1jwit7boVQkFP5DF++DNRorQ7SAjQSBpvK/9WeJAMLXq2owGK4KmgsfqmTbK3YnAjxkcP7nQQhsJGPaKokGWO4ky7MLHeh3+E2Db1GTCpfQ1NPbX0aFiuwNPy+lLlSOr2hnmbeQLEQjLLk1ckQcVQetWOm4f4kdngG0rBEsQwXGyQIDAQAB";

    /**
     *  登录的方法，返回值是一个token(jwt)
     *  @return
     */
    public static String login(String username , String pwd){
        /** 通过用户名和密码判断是否登录成功？成功后开始生成token */
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            Date expiresDate = new Date(System.currentTimeMillis() + (1000 * 60 * 2));
            String token = JWT.create()
                    .withIssuer("auth0")//设置签发者
                    .withClaim("uid", 2222)//用户的id，需要存储其他信息，可以继续在后面增加withClaim
                    .withExpiresAt(expiresDate)
                    .sign(algorithm);
            System.out.println(token);
            return token;
        } catch (JWTCreationException exception){
            exception.printStackTrace();
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return null;
    }
    /**
     *  获取用户的购物车信息
     *  @Param token :用户登录后签发给他的token(jwt)
     *  @return
     */
    public static void selectShopCart(String token){
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0").build();
        try{
            /** 验证token的有效性(1.token是否是由我方生成 2.有没有被篡改过) */
            DecodedJWT decodedJWT = verifier.verify(token);
            Claim uidClaim = decodedJWT.getClaim("uid");
            System.out.println("要获取购物车信息的用户id:" + uidClaim.asInt());
        } catch (Exception e){
            System.out.println("token的有效性验证失败，或者token已经过期");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String token = login("" , "");
        selectShopCart(token);

    }
}
