package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;
import menu.exception.Validator;
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
        List<String> names = new ArrayList<>();
        Map<String, List<String>> hateMenu = new LinkedHashMap<>();
        try {
            names = inputView.readCoachName();
            hateMenu = inputView.readHateFood(names);
        } catch (IllegalArgumentException | NoSuchElementException e) { // 입력안함은 여기서 자동 제거
            System.out.println(e.getMessage());
        }
        Map<String, List<String>> finalRecommenedMenu = menuService.recommendMenu(names, hateMenu);
        outputView.printResult(names, finalRecommenedMenu);
    }


}
