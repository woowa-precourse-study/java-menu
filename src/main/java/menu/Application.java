package menu;

import menu.controller.MenuController;

public class Application {

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        try {
            menuController.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

