package com.dhu.ats.mapper;

import com.dhu.ats.model.User;

public interface UserServiceMapper {
    public User findUserById(int userId);
    public User findByUsername(User user);
}
