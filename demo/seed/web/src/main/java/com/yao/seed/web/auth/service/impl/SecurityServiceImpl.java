package com.yao.seed.web.auth.service.impl;

import com.yao.seed.commons.user.entity.User;
import com.yao.seed.commons.user.service.UserService;
import com.yao.seed.core.auth.config.AuthConfig;
import com.yao.seed.web.auth.service.SecurityService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;


    @Override
    public void login(String username, String password, HttpServletRequest request) {

        User user = userService.findByName(username);
        Assert.isTrue(null != user && StringUtils.isNotBlank(user.getPwd()) && passwordEncoder.matches(password, user.getPwd()), "用户名|密码 错误");

        logger.info("User[{}] login.success", username);
        request.getSession().setAttribute(AuthConfig.authSessionKey, user.getId());
    }
}
