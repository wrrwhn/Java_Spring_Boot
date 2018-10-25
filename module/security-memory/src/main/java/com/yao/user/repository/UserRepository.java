package com.yao.user.repository;

import com.yao.user.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Creator: Yao
 * Date:    2018/10/19
 * For:
 * Other:
 */
public interface UserRepository extends CrudRepository<User, Long> {


    User findFirstByName(String name);
}
