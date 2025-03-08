package abstractFabric.factory;

import abstractFabric.button.Button;
import abstractFabric.button.HtmlButton;
import abstractFabric.lable.HtmlLable;
import abstractFabric.lable.Lable;

public class HtmlFactory implements GULfactory{

    @Override
    public Button createButton() {
        return new HtmlButton();
    }

    @Override
    public Lable createLable() {
        return new HtmlLable();
    }
}
