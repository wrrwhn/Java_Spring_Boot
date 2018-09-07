package com.yao.seed.web.auth.interceptor;

import com.yao.seed.core.auth.config.AuthConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Long authUserId = (Long) session.getAttribute(AuthConfig.authSessionKey);

        logger.debug("request.user: {}", authUserId);
        if (null != authUserId) {
            request.setAttribute(AuthConfig.authSessionKey, authUserId);
            return true;
        } else {
            logger.warn("UNAUTHORIZED session:{}", session.getId());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
            return false;
        }
    }
}
