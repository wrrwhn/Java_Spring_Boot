package com.yao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Creator: Yao
 * Date:    2018/10/29
 * For:
 * Other:
 */
@Configuration
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        if (null != session.getAttribute(SecurityMvcConfig.SESSION_KEY)) {
            return true;
        }
        response.getWriter().write("Login first, please");
        return false;
    }
}
