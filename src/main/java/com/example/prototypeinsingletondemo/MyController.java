// package com.example.prototypeinsingletondemo;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class MyController {
//
//     @Autowired
//     MyPrototypeBean myPrototypeBean;
//
//
//     @Autowired
//     public void setMyBean(MyPrototypeBean myPrototypeBean) {
//         System.out.println("In setter of myBean");
//         this.myPrototypeBean = myPrototypeBean;
//     }
//
//     @GetMapping("/")
//     public void getCounter() {
//         myPrototypeBean.print();
//         myPrototypeBean.counter.get();
//         myPrototypeBean.print();
//         myPrototypeBean.print();
//     }
//
// }
