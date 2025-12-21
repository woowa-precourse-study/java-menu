package menu;

import menu.controller.MenuController;
import menu.factory.ApplicationFactory;

public class Application {
    public static void main(String[] args) {
        ApplicationFactory factory = new ApplicationFactory();
        MenuController controller = factory.controller();

        controller.run();
    }
}
