package com.yao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
@WebFilter(urlPatterns = "/*", filterName = "filter.log")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 请求前处理
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        // 请求后处理
        System.out.printf("Request[%s].cost= %d\n", ((HttpServletRequest) request).getRequestURL(), System.currentTimeMillis() - start);
    }
}