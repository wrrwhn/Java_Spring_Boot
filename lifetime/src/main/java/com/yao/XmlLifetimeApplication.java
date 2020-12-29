package com.yao;

import com.yao.logic.service.LogicBean;
import com.yao.logic.service.LogicFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qingju.yao
 * @date 2020/12/09
 */
public class XmlLifetimeApplication {

    public static void main(String[] args) throws Exception {

        System.out.println("XmlLifetimeApplication.main.start");

        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("XmlLifetimeApplication.Init");

        final LogicBean logicBean = context.getBean("logicBean", LogicBean.class);
        System.out.println(logicBean);

        // 注册LogicFactoryBean 但实际渲染的对象为 LogicFactoryBean.LogicFactoryBeanInner
        final LogicFactoryBean.LogicFactoryBeanInner inner = (LogicFactoryBean.LogicFactoryBeanInner) context.getBean("logicFactoryBean");
        System.out.println(inner);

        System.out.println("XmlLifetimeApplication.shutdown");
        context.registerShutdownHook();
    }
}
