package com.yao.seed.web.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creator: Yao
 * Date:    2018/9/7
 * For:
 * Other:
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<String> list() {

        return Stream.of("Resource-1", "Resource-2").collect(Collectors.toList());
    }
}
