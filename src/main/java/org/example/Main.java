package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MyService myService = (MyService) context.getBean("myService");

//        System.out.println(myService.calculate(1,2));
//        System.out.println(myService.returnString("1","2"));
        System.out.println(myService.returnName("Pavel"));
//        myService.emptyMethod();
    }
}
