package com.example.prototypeinsingletondemo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// @Component
public class SingletonAppContextBean implements ApplicationContextAware {
    static ApplicationContext applicationContext;

    public SingletonAppContextBean() {
        System.out.println("Inside SingletonAppContextBean constructor");
    }

    public static MyPrototypeBean getMyPrototypeBean() {
        return applicationContext.getBean(MyPrototypeBean.class);
    }


    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
}
