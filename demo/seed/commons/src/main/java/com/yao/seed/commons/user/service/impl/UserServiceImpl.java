package com.yao.seed.commons.user.service.impl;

import com.yao.seed.commons.user.entity.User;
import com.yao.seed.commons.user.repository.UserRepository;
import com.yao.seed.commons.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User get(Long id) {

        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User add(User p) {

        // check
        Assert.notNull(p, "未提供用户信息");
        User q = userRepository.findByName(p.getName());
        Assert.isNull(q, "该用户名已被使用");
        Assert.isTrue(StringUtils.isNotBlank(p.getPwd()), "密码为空");

        p.setPwd(passwordEncoder.encode(p.getPwd()));
        return userRepository.save(p);
    }

    @Override
    @Transactional
    public User update(User p) {

        // check
        Assert.notNull(p, "未提供用户信息");
        User q = userRepository.findByName(p.getName());
        Assert.notNull(q, "未找到指定用户名用户");
        Assert.isTrue(StringUtils.isNotBlank(p.getPwd()), "密码为空");

        q.setPwd(passwordEncoder.encode(p.getPwd()));
        return userRepository.save(q);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        // check
        Assert.notNull(id, "未提供用户 ID");
        User user = get(id);
        Assert.notNull(user, "未找到指定用户");

        userRepository.delete(user);
    }

    @Override
    public Page<User> page(String name, Integer page, Integer size) {

        // init
        name = StringUtils.isNotBlank(name) ? name : "";
        page = (null == page || page <= 0) ? 1 : page;
        size = (null == size || size <= 0) ? 10 : size;

        return userRepository.findByNameLike(
                String.format("%%%s%%", name),
                new PageRequest(page - 1, size, new Sort(Sort.Direction.DESC, "id")));
    }

    @Override
    public User findByName(String username) {

        // check
        if (StringUtils.isBlank(username))
            return null;

        return userRepository.findByName(username);
    }
}