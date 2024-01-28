package com.example.prototypeinsingletondemo;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SingletonProviderBean {

    public SingletonProviderBean() {
        System.out.println("Inside SingletonProviderBean");
    }

    @Autowired
    private ObjectProvider<MyPrototypeBean> myPrototypeBeanProvider;
    // Instead of using javax.inject.Provider, use Spring's ObjectProvider which is designed to handle prototype beans more effectively within a singleton bean.

    public MyPrototypeBean getPrototypeInstance() {
        return myPrototypeBeanProvider.getObject();
    }
}
