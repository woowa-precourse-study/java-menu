package menu.controller;

import menu.service.MenuService;

import java.util.*;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.menuService = menuService;
    }

    public void run() {
        List<String> names = inputView.readCoachName();
        Map<String, List<String>> hateMenu = inputView.readHateFood(names);
        Map<String, List<String>> finalRecommenedMenu = menuService.recommendMenu(names, hateMenu);
        outputView.printResult(names, finalRecommenedMenu);
    }


}
