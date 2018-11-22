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
@RequestMapping("/resource")
public class ResourceController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable @NotNull Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.format("Resource[%s]: %s", id, authentication.getName());
    }

    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public String getDetail(@PathVariable @NotNull Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.format("Resource[%s].detail: %s", id, authentication.getName());
    }
}
