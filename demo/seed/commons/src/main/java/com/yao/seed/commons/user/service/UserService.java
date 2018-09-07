package com.yao.seed.commons.user.service;

import com.yao.seed.commons.user.entity.User;
import org.springframework.data.domain.Page;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public interface UserService {

    User get(Long id);

    User add(User user);

    User update(User user);

    void delete(Long id);

    Page<User> page(String key, Integer page, Integer size);

    User findByName(String username);
}
