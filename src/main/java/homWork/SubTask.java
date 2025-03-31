package homWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class SubTask {
//    @Qualifier("nameTaskSub")
    @Autowired
    private String nameSub;


    @Autowired
    private List<Task> taskList;

    public void getName() {

        System.out.println(nameSub);
    }

    public void setName(String name) {
        this.nameSub = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    public void executeSubTask() {
        System.out.println("Executing [TASK] " + nameSub);
        if (taskList != null) {
            for (Task task : taskList) {
                task.execute();
            }
        }
    }
}
