package com.yao.seed.commons.user.repository;

import com.yao.seed.commons.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findByNameLike(String name, Pageable pageable);

    User findById(Long id);

    User findByName(String name);
}
