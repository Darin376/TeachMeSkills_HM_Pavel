package SpringPack2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringHelloWorld2 bean = context.getBean("aaa",SpringHelloWorld2.class);
//        String massage = context.getBean("innerMessage33",String.class);
        bean.getInnerClass2();
        bean.getMassage();
    }
}
