package com.ly.user.service.controller;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.commons.bo.user.LoginBO;
import com.ly.commons.dto.ResponseData;
import com.ly.commons.utils.JwtUtils;
import com.ly.user.service.entity.Users;
import com.ly.user.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName UserController
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@RestController
public class UserController
{
    @Autowired
    private UserMapper userMapper;
    /**
     *  登录，返回时一个jwt的token
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    @PostMapping("/login")
    public ResponseData<String> login(@RequestBody LoginBO loginBO)
    {
        ResponseData responseData = new ResponseData();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username" , loginBO.getUsername());
        queryWrapper.eq("password" , loginBO.getPwd());
        Users u = this.userMapper.selectOne(queryWrapper);
        if(u == null){
            responseData.setCode(ResponseData.ResultCode.FAIL);
            responseData.setMsg("登录失败!请检查用户名和密码！");
        } else {
            u.setPassword(null);
            String token = JwtUtils.createToken(JSON.toJSONString(u));
            responseData.setData(token);
        }
        return responseData;
    }
}
