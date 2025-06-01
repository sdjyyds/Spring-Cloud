package com.sdjyyds.user.web;

import com.sdjyyds.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jds
 * @version 1.1
 * @since 1.0.0
 */
@RestController
@Slf4j
public class UserController {
     @Autowired
     private UserService UserService;
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        User user = UserService.getUserById(id);
        if( user != null) {
            log.info("查询到用户信息：{}", user);
            return user;
        }
         log.info("没有查询到用户信息");
          return null;
    }
}
