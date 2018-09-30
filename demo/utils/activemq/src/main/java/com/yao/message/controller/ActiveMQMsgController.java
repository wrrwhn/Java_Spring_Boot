package com.yao.message.controller;

import com.yao.message.service.ActiveMQMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator: Yao
 * Date:    2018/9/29
 * For:
 * Other:
 */
@RestController
@RequestMapping("/mq/active")
public class ActiveMQMsgController {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${config.msg:channel:}")
    private String channel;


    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public void send(@RequestParam String msg) {

        jmsTemplate.send(channel, new ActiveMQMsg(msg));
    }
}
