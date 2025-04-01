package org.example;

public class MyService {

    public int calculate(int a, int b) {
        return a + b;
    }
    @AspectAnnotation
    public String returnString(String a, String b) {
        return a + "Hello" +b;
    }
    public void emptyMethod(){
        System.out.println("no action");
    }
    @AspectNAme
    public String returnName(String a) {
        return a + "   plingon" ;
    }

    public String returnName2(String a) {

        return a + "plingon" ;
    }
}
