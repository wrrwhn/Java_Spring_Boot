package com.yao.message.service;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Creator: Yao
 * Date:    2018/9/29
 * For:
 * Other:
 */
public class ActiveMQMsg implements MessageCreator {

    private String msg;

    public ActiveMQMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        System.out.printf("-> %s\n", msg);
        return session.createTextMessage(msg);
    }
}
