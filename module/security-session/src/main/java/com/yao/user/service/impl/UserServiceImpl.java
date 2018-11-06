package com.yao.user.service.impl;

import com.yao.config.SecurityMvcConfig;
import com.yao.user.entity.User;
import com.yao.user.repository.UserRepository;
import com.yao.user.service.UserService;
import com.yao.user.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Creator: Yao
 * Date:    2018/10/19
 * For:
 * Other:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String name) {

        Assert.isTrue(StringUtils.isNotBlank(name), "未提供用户姓名");
        return repository.findFirstByUsername(name);
    }

    @Override
    public List<User> list() {
        return (List<User>) repository.findAll();
    }

    @Override
    public void login(String username, String password, HttpSession session) {

        Assert.isTrue(StringUtils.isNotBlank(username), "未提供用户姓名");
        Assert.isTrue(StringUtils.isNotBlank(password), "未提供用户密码");
        User user = repository.findFirstByUsername(username);
        Assert.notNull(user, "未找到指定用户");
        Assert.isTrue(passwordEncoder.matches(password, user.getPassword()), "用户名或密码不匹配");

        session.setAttribute(SecurityMvcConfig.SESSION_KEY, user);
    }

    @Override
    public void logout(HttpSession session) {

        session.removeAttribute(SecurityMvcConfig.SESSION_KEY);
    }

    @Override
    public void login(UserVo userVo, HttpSession session) {

        Assert.notNull(userVo, "未提供登录相关信息");
        Assert.isTrue(StringUtils.isNotBlank(userVo.getUsername()), "未提供用户姓名");
        Assert.isTrue(StringUtils.isNotBlank(userVo.getPassword()), "未提供用户密码");
        User user = repository.findFirstByUsername(userVo.getUsername());
        Assert.notNull(user, "未找到指定用户");
        Assert.isTrue(passwordEncoder.matches(userVo.getPassword(), user.getPassword()), "用户名或密码不匹配");

        session.setAttribute(SecurityMvcConfig.SESSION_KEY, user);
    }
}
