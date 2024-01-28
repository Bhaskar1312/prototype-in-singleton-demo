package com.example.prototypeinsingletondemo;

import java.util.Objects;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication

public class App {

// https://github.com/eugenp/tutorials/tree/master/spring-core/src/main/java/com/baeldung/scope/singleton
    public static void main(String[] args) {
        // SpringApplication.run(App.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //  method 1, DependsOn for(what if new) 2?, 3

        // Method 1 - applicationContext and Scope("prototype")
        MySingletonBean firstSingleton = context.getBean(MySingletonBean.class);
        MyPrototypeBean firstPrototype = context.getBean(MyPrototypeBean.class);

        MySingletonBean secondSingleton = context.getBean(MySingletonBean.class);
        MyPrototypeBean secondPrototype = context.getBean(MyPrototypeBean.class);

        System.out.println(firstSingleton.equals(secondSingleton));
        System.out.println(!firstPrototype.equals(secondPrototype));


        // Method 2 - SingletonAppContextBean, ApplicationContextAware without Scope
        // SingletonAppContextBean singletonAppContextBean = new SingletonAppContextBean(); // use static or object
        MyPrototypeBean firstPrototype1 = SingletonAppContextBean.applicationContext.getBean(MyPrototypeBean.class);
        MyPrototypeBean secondPrototype1 = SingletonAppContextBean.applicationContext.getBean(MyPrototypeBean.class);
        MyPrototypeBean thirdPrototype1 = SingletonAppContextBean.applicationContext.getBean(MyPrototypeBean.class);
        System.out.println(!firstPrototype1.equals(secondPrototype1));
        System.out.println(!thirdPrototype1.equals(firstPrototype1));


        // Method 3 - Method injection/lookup
        SingletonLookupBean singletonLookupBean = context.getBean(SingletonLookupBean.class);
        MyPrototypeBean firstPrototype2 = singletonLookupBean.getMyPrototypeBean();
        MyPrototypeBean secondPrototype2 = singletonLookupBean.getMyPrototypeBean();
        MyPrototypeBean thirdPrototype2 = singletonLookupBean.getMyPrototypeBean();
        System.out.println(!firstPrototype2.equals(secondPrototype2));
        System.out.println(!thirdPrototype2.equals(firstPrototype2));


        // Method 4 - inject Provider or better spring's ObjectProvider
        SingletonProviderBean singletonProviderBean = context.getBean(SingletonProviderBean.class);
        MyPrototypeBean firstPrototype3 = singletonProviderBean.getPrototypeInstance();
        MyPrototypeBean secondPrototype3 = singletonProviderBean.getPrototypeInstance();
        MyPrototypeBean thirdPrototype3 = singletonProviderBean.getPrototypeInstance();
        System.out.println(!firstPrototype3.equals(secondPrototype3));
        System.out.println(!thirdPrototype3.equals(firstPrototype3));

        // Method-5 Scoped Proxy
        // AppProxyConfig config = new AppProxyConfig();
        AnnotationConfigApplicationContext proxyContext = new AnnotationConfigApplicationContext(AppProxyConfig.class);
        MyPrototypeBean firstPrototype4 =  proxyContext.getBean(MyPrototypeBean.class);
        firstPrototype4.print();
        firstPrototype4.print();
        MyPrototypeBean secondPrototype4 = proxyContext.getBean(MyPrototypeBean.class); // config.myPrototypeBean();
        secondPrototype4.print();
        System.out.println("counter after 3 accesses: "+MyPrototypeBean.counter);
        MyPrototypeBean thirdPrototype4 = proxyContext.getBean(MyPrototypeBean.class);
        thirdPrototype4.print();
        System.out.println("counter after 4 accesses: "+MyPrototypeBean.counter);
        thirdPrototype4.print();
        System.out.println("counter after 5 accesses: "+MyPrototypeBean.counter);
        System.out.println(!Objects.equals(firstPrototype4, secondPrototype4));
        System.out.println("counter after ? accesses: "+MyPrototypeBean.counter);
        System.out.println("counter after ? accesses: "+MyPrototypeBean.counter);
        System.out.println(!thirdPrototype4.equals(firstPrototype4));

    }

    static void temp(ApplicationContext context) {
        System.out.println(">>"+context.getBeanDefinitionNames());
    }

}
