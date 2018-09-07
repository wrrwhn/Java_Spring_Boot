package com.yao.seed.web.user.controller;

import com.yao.seed.core.page.vo.PageVo;
import com.yao.seed.web.auth.service.SecurityService;
import com.yao.seed.web.user.service.UserLogicService;
import com.yao.seed.web.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * Creator: Yao
 * Date:    2018/9/7
 * For:
 * Other:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserLogicService userLogicService;
    @Autowired
    SecurityService securityService;


    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public UserVo get(@PathVariable @NotNull Long id) {

        return userLogicService.get(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public UserVo add(@RequestBody @NotNull UserVo userVo) {

        return userLogicService.add(userVo);
    }

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.PUT)
    public UserVo update(
            @RequestBody @NotNull UserVo userVo) {

        return userLogicService.update(userVo);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public PageVo<UserVo> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        return userLogicService.pageByName(name, page, size);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody UserVo userVo, HttpServletRequest request) {
        securityService.login(userVo.getName(), userVo.getPwd(), request);
    }
}
