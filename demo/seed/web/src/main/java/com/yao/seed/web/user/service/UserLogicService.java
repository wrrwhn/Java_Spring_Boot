package com.yao.seed.web.user.service;

import com.yao.seed.commons.user.entity.User;
import com.yao.seed.commons.user.service.UserService;
import com.yao.seed.core.page.vo.PageVo;
import com.yao.seed.web.user.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

/**
 * Creator: Yao
 * Date:    2018/9/7
 * For:
 * Other:
 */
@Service
public class UserLogicService {

    @Autowired
    UserService userService;


    public UserVo get(@NotNull Long id) {

        // check
        Assert.notNull(id, "未提供用户 ID");

        // init
        UserVo q = null;

        // query
        User p = userService.get(id);
        if (null != p) {
            q = new UserVo();
            BeanUtils.copyProperties(p, q);
        }

        return q;
    }

    public UserVo add(@NotNull UserVo p) {

        // check
        Assert.notNull(p, "未提供用户信息");

        // init
        User q = new User();
        BeanUtils.copyProperties(p, q);
        q = userService.add(q);

        BeanUtils.copyProperties(q, p);
        return p;
    }

    public UserVo update(@NotNull UserVo p) {

        // check
        Assert.notNull(p, "未提供用户信息");

        // init
        User q = new User();
        BeanUtils.copyProperties(p, q);
        q = userService.update(q);

        BeanUtils.copyProperties(q, p);
        return p;
    }

    public PageVo<UserVo> pageByName(String name, Integer page, Integer size) {

        // init
        PageVo<UserVo> q = new PageVo<>(UserVo.class);
        Page<User> p = userService.page(name, page, size);
        q.copyProperties(p);

        return q;
    }
}
