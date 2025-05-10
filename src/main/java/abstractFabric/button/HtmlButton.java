package abstractFabric.button;

public class HtmlButton implements Button {

    @Override
    public void paint() {
        System.out.println("HtmlButton");
    }
}
