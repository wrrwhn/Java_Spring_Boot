package com.yao.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
public class ORSessionListener implements HttpSessionListener {

    public static final String SESSION_LIVE_COUNT = "SESSION-LIVE-COUNT";


    @Override
    public void sessionCreated(HttpSessionEvent se) {

        System.out.println("\tOverride.HttpSession.Listener.init");

        Object obj = se.getSession().getAttribute(SESSION_LIVE_COUNT);
        se.getSession().setAttribute(SESSION_LIVE_COUNT, null == obj ? 1 : Integer.valueOf(obj.toString()) + 1);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println("\tOverride.HttpSession.Listener.destroy");

        Object obj = se.getSession().getAttribute(SESSION_LIVE_COUNT);
        se.getSession().setAttribute(SESSION_LIVE_COUNT, null == obj ? 0 : Integer.valueOf(obj.toString()) - 1);
    }
}
