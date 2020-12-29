package com.yao.logic;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author qingju.yao
 * @date 2020/12/13
 */
public class LogicSmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("LogicSmartInitializingSingleton\tafterSingletonsInstantiated");
    }
}
