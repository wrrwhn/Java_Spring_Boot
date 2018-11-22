package com.yao.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Creator: Yao
 * Date:    2018/11/14
 * For:
 * Other:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable @NotNull Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.format("User[%s]: %s", id, authentication.getName());
    }
}
