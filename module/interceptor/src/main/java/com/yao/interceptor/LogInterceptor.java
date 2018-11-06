package com.yao.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
public class LogInterceptor implements HandlerInterceptor {

    private final String LOG_KEY = "INTERCEPTOR_LOG_KEY";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute(LOG_KEY, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        long start = (long) request.getAttribute(LOG_KEY);
        System.out.printf("Request[%s].cost= %d\n", ((HttpServletRequest) request).getRequestURL(), System.currentTimeMillis() - start);
    }
}
