package com.yao;

import com.yao.service.IMessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassPath XML Starter
 *
 * @author qingju.yao
 * @date 2020/08/03
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("Context.init");

        IMessageService service = context.getBean(IMessageService.class);
        service.send(Application.class.getSimpleName());
    }
}
