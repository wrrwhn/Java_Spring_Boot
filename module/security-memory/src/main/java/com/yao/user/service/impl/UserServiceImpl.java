package com.yao.user.service.impl;

import com.yao.user.entity.User;
import com.yao.user.repository.UserRepository;
import com.yao.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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


    @Override
    public User findByName(String name) {

        Assert.isTrue(StringUtils.isNotBlank(name), "未提供用户姓名");
        return repository.findFirstByName(name);
    }

    @Override
    public List<User> list() {
        return (List<User>) repository.findAll();
    }
}
