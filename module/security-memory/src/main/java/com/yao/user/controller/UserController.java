package com.yao.user.controller;

import com.yao.user.entity.User;
import com.yao.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creator: Yao
 * Date:    2018/10/18
 * For:
 * Other:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<User> list() {

        return userService.list();
    }
}
