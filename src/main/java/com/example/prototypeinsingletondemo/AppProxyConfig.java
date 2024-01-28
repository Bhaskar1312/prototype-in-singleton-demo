package com.example.prototypeinsingletondemo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppProxyConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    // with target class, bean won't be created until cglib proxy is accessed for the first time and new instance is created everytime we access proxy
    public MyPrototypeBean myPrototypeBean() {
        System.out.println("Proxy bean method");
        return new MyPrototypeBean();
    }
}
