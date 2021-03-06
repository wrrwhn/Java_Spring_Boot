package com.yao.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<String> list() {

        return Stream.of("admin", "user").collect(Collectors.toList());
    }
}
