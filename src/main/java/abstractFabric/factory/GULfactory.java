package abstractFabric.factory;

import abstractFabric.button.Button;
import abstractFabric.lable.Lable;

public interface GULfactory {
    Button createButton();

    Lable createLable();
}
