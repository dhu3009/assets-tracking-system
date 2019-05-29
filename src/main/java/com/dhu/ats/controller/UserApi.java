package com.dhu.ats.controller;

import com.dhu.ats.annotation.UserLoginToken;
import com.dhu.ats.model.JSONObject;
import com.dhu.ats.model.User;
import com.dhu.ats.service.TokenService;
import com.dhu.ats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken

    @RequestMapping(value = {"/getMessage"}, method = RequestMethod.GET)
    public String getMessage(){
        return "你已通过验证";
    }
}