package SpringPack2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SpringHelloWorld2 {
//    @Qualifier("Shark")
    @Autowired
    private String massage;
    @Autowired
    private  InnerClass2 innerClass23;

    public void getMassage() {
        System.out.println(massage);
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void   getInnerClass2() {
        System.out.println(innerClass23);
    }

    public void setInnerClass2(InnerClass2 innerClass2) {
        this.innerClass23 = innerClass2;
    }
}