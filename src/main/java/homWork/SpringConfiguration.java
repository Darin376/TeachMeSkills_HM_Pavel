package homWork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SpringConfiguration {

    @Scope("prototype")
    @Bean
    public SubTask aaa(){
        return new SubTask();
    }
   @Bean("task11")
    public Task getTask1(){
        Task task =  new Task();
        task.setName("Oleg1111");
        return task;
    }
    @Bean("task22")
    public Task getTask2(){
        Task task =  new Task();
        task.setName("Pavel1111");
        return task;
    }


    @Bean("task33")
    public Task getTask3(){
        Task task =  new Task();
        task.setName("Ilya1111");
        return task;
    }
  @Bean("listTask")
    public List<Task> getTasks(){
//        List<Task> tasks = new ArrayList<Task>();
//        tasks.add(getTask1());
//        tasks.add(getTask2());
//        tasks.add(getTask3());
//        return tasks;
        return Arrays.asList(getTask1(),getTask2(),getTask3());
    }

    @Bean("nameSub")
    public String getMyMessage()
    {

        return "Hello World!!!";
    }

}
