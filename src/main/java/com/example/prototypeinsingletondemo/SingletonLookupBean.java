package com.example.prototypeinsingletondemo;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonLookupBean {

    @Lookup
    public MyPrototypeBean getMyPrototypeBean() {
        return null;
    }
}
