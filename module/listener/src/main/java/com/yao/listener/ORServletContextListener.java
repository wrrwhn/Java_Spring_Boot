package com.yao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
public class ORServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("\tOverride.ServletContext.Listener.init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\tOverride.ServletContext.Listener.destroy");
    }
}
