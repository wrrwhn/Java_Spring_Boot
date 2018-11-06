package com.yao.user.service;

import com.yao.user.entity.User;

import java.util.List;

/**
 * Creator: Yao
 * Date:    2018/10/19
 * For:
 * Other:
 */
public interface UserService {


    User findByUsername(String name);

    List<User> list();
}
