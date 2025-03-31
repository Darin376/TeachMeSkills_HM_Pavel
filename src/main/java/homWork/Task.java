package homWork;

public class Task {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void execute() {
        System.out.println("  Executing [SUBTASK]: " + name);
    }
}
