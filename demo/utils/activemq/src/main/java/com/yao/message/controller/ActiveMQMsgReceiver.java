package com.yao.message.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Creator: Yao
 * Date:    2018/9/29
 * For:
 * Other:
 */
@Component
public class ActiveMQMsgReceiver {

    @JmsListener(destination = "${config.msg:channel:}")
    public void receive(String msg) {

        System.out.printf("<- %s\n", msg);
    }
}
