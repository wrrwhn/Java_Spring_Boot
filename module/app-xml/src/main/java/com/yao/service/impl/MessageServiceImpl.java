package com.yao.service.impl;

import com.yao.service.IMessageService;

/**
 * @author qingju.yao
 * @date 2020/08/03
 */
public class MessageServiceImpl implements IMessageService {

    public void send(String msg) {
        System.out.println("MessageServiceImpl.send(" + msg + ")");
    }
}
