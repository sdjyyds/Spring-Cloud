package com.sdjyyds.user.web;

import com.sdjyyds.user.entity.User;
import com.sdjyyds.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jds
 * @version 1.1
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserById(int id)
    {
        return userMapper.getUserById(id);
    }
}
