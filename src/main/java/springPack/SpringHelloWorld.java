package springPack;


public class SpringHelloWorld {
    private String massage;
    private  InnerClass innerClass;

    public void getMassage() {
        System.out.println(massage);
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public InnerClass getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }
}
