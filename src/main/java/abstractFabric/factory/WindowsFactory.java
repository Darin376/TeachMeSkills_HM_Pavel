package abstractFabric.factory;

import abstractFabric.button.Button;
import abstractFabric.button.WindowsButton;
import abstractFabric.lable.Lable;
import abstractFabric.lable.WindowsLable;

public class WindowsFactory implements GULfactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Lable createLable() {
        return new WindowsLable();
    }
}
