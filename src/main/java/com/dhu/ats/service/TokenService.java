package com.dhu.ats.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dhu.ats.model.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {
    public String getToken(User user) {
//        Long mills = System.currentTimeMillis();
//        Date now = new Date(mills);
//        Date expireDate = new Date(mills + 1000*60*60);


        String token="";

        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
