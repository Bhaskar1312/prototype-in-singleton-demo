package com.example.prototypeinsingletondemo;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPrototypeBean {
    static final AtomicLong counter = new AtomicLong();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public MyPrototypeBean() {
        logger.info("Prototype bean created default {}",counter.incrementAndGet());
    }
    public void print() {
        logger.info("counter.get() = {}",  counter.get());
    }
}
