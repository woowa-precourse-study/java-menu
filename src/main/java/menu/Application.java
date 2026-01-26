package menu;

import menu.controller.MenuController;
import menu.service.MenuService;

public class Application {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        MenuController menuController = new MenuController(menuService);
        menuController.run();
    }
}
