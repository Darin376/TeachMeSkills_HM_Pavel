package springPack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("my-config.xml");
        SpringHelloWorld springHelloWorld = (SpringHelloWorld) context.getBean("aaa");
        SpringHelloWorld springHelloWorld2 =  context.getBean("aaa",SpringHelloWorld.class);
        springHelloWorld.getMassage();
        springHelloWorld.getInnerClass();

        System.out.println(springHelloWorld2==springHelloWorld);

        springHelloWorld.setMassage("new");
        springHelloWorld.getMassage();
    }
}
