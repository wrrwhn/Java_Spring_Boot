package com.yao.user.controller;

import com.yao.listener.ORSessionListener;
import com.yao.user.vo.UserVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    private final String USER_SESSION_KEY = "SESSION:USER";


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<String> list() {

        return Stream.of("admin", "user").collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVo get(@PathVariable Long id, HttpServletRequest request) {

        request.getSession().setAttribute(USER_SESSION_KEY, id);
        return new UserVo(id, "admin");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id, HttpServletRequest request) {

        request.getSession().removeAttribute(USER_SESSION_KEY);
    }

    @RequestMapping(value = "/live", method = RequestMethod.GET)
    public Integer live(HttpServletRequest request) {

        Object obj = request.getSession().getAttribute(ORSessionListener.SESSION_LIVE_COUNT);
        return null == obj ? 0 : Integer.parseInt(obj.toString());
    }
}
