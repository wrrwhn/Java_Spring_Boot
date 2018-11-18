package com.yao.user.controller;

import com.yao.config.SecurityMvcConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creator: Yao
 * Date:    2018/10/18
 * For:
 * Other:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<String> list(HttpSession session) {
        return Stream.of(session.getAttribute(SecurityMvcConfig.SESSION_KEY).toString()).collect(Collectors.toList());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(String username, String password, HttpSession session) {

        Assert.isTrue(StringUtils.isNotBlank(username), "");
        Assert.isTrue(StringUtils.isNotBlank(password), "");

        session.setAttribute(SecurityMvcConfig.SESSION_KEY, 1);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    public void login(HttpSession session) {

        session.removeAttribute(SecurityMvcConfig.SESSION_KEY);
    }
}
