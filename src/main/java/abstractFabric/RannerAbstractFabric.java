package abstractFabric;

import abstractFabric.button.Button;
import abstractFabric.factory.GULfactory;
import abstractFabric.factory.HtmlFactory;
import abstractFabric.factory.WindowsFactory;
import abstractFabric.lable.Lable;

public class RannerAbstractFabric {
    private static GULfactory gulfactory;

    public static void main(String[] args) {
        init("html");
        paint();
    }

    private static void init(String protect) {
        if (protect.equals("htnl")) {
            gulfactory = new HtmlFactory();
        } else {
            gulfactory = new WindowsFactory();
        }
    }

    public static void paint(){
        Button button = gulfactory.createButton();
        Lable lable = gulfactory.createLable();
        button.paint();
        lable.display();
    }
}
