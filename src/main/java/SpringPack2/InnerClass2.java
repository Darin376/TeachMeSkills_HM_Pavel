package SpringPack2;

import org.springframework.beans.factory.annotation.Autowired;

public class InnerClass2 {
    @Autowired
    private String innerMessage33;

    public String getInnerMessage() {
        return innerMessage33;
    }

    @Override
    public String toString() {
        return "InnerClass2{" +
                "innerMessage='" + innerMessage33 + '\'' +
                '}';
    }

    public void setInnerMessage(String innerMessage) {
        this.innerMessage33 = innerMessage;
    }
}
