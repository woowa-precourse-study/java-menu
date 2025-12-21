package menu.controller;

import menu.service.MenuDto;
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
        MenuDto finalRecommenedMenu = menuService.recommendMenu(names, hateMenu);
        outputView.printResult(names, finalRecommenedMenu.getRecommendedCategories(),finalRecommenedMenu.getRecommendedFoods());
    }


}
