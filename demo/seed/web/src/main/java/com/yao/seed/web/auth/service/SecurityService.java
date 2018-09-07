package com.yao.seed.web.auth.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public interface SecurityService {

    void login(String username, String password, HttpServletRequest request);
}
