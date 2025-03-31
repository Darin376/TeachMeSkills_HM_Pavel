package homWork;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ranner {
    public static void main(String[] args) {
        ApplicationContext context1 = new ClassPathXmlApplicationContext("my-config.xml");
        Task task1 = (Task) context1.getBean("task3");
        SubTask task2 = (SubTask) context1.getBean("subTask");

//        Task task2 = context1.getBean("task2", Task.class);
//        task1.execute();
//        task2.executeSubTask();
//        task2.getName();



        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SubTask task3 = (SubTask) context.getBean("aaa");
        Task task4 = (Task) context.getBean("task11");
//        Task task5 = (Task) context.getBean("Pasha");
task3.getName();
//        task4.execute();
//        task3.executeSubTask();
    }
}
