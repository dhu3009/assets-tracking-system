package com.dhu.ats.service;

import com.dhu.ats.mapper.UserServiceMapper;
import com.dhu.ats.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserServiceMapper userServiceMapper;

    public User findUserById(int userId){
        return userServiceMapper.findUserById(userId);
    }

    public User findByUsername(User user){
        return userServiceMapper.findByUsername(user);
    }
}
