package com.yao.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * Creator: Yao
 * Date:    2018/11/14
 * For:
 * Other:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @RequestMapping(value = "/get/{key:[\\w]+}", method = RequestMethod.GET)
    public String get(@PathVariable @NotBlank String key) {

        return stringRedisTemplate.opsForValue().get(key);
    }
}
