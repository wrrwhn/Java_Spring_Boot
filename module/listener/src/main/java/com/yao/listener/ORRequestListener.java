package com.yao.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
public class ORRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("\tOverride.ServletRequest.Listener.init");
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("\tOverride.ServletRequest.Listener.destroy");
    }
}
