package com.yao.user.controller;

import com.yao.user.entity.User;
import com.yao.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/size", method = RequestMethod.GET)
    public Integer size() {
        return userService.list().size();
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public User find(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/role/all", method = RequestMethod.GET)
    public String permitAll() {
        return "permitAll";
    }

    @RequestMapping(value = "/role/user", method = RequestMethod.GET)
    public String permitUser() {
        return "permitUser";
    }

    @RequestMapping(value = "/role/admin", method = RequestMethod.GET)
    public String permitAdmin() {
        return "permitAdmin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(String username, String password, HttpSession session) {
        userService.login(username, password, session);
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public void login(UserVo user, HttpSession session) {
//        userService.login(user, session);
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void login(HttpSession session) {
        userService.logout(session);
    }
}
