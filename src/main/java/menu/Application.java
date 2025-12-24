package menu;

import menu.controller.MenuController;
import menu.service.MenuService;

public class Application {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        MenuController menuController = new MenuController(menuService);
        try {
            menuController.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

