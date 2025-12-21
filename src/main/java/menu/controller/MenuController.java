package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;
import menu.exception.Validator;

import java.util.*;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        List<String> names = new ArrayList<>();

        Map<String, List<String>> hateMenu = new LinkedHashMap<>();
        Map<String, List<String>> finalRecommenedMenu = new LinkedHashMap<>();
        try {
            names = inputView.readCoachName();
            hateMenu = inputView.readHateFood(names);
        } catch (IllegalArgumentException | NoSuchElementException e) { // 입력안함은 여기서 자동 제거
            System.out.println(e.getMessage());
        }

        Set recommendedCategories = new HashSet();
        // 월 ~ 금까지 메뉴 추천
        while (recommendedCategories.size() < 5) {
            int num = Randoms.pickNumberInRange(1, 5);
            Validator.validateRange(num, 1, 5);
            String category = Menu.getCategoriesByNumber(num);
            if (recommendedCategories.contains(category)) {
                continue;
            }

            // 해당 카테고리의 음식 추천
            List<String> menus = Menu.getFoodsByCategory(category);

            for (String name : names) {
                String menu = "INVALID";
                if (!finalRecommenedMenu.containsKey(name)) {
                    finalRecommenedMenu.put(name, new ArrayList<>());
                }

                while (menu.equals("INVALID")) {
                    menu = Randoms.shuffle(menus).get(0);
                    // 해당 코치가 싫어하는 음식인지 확인 + 이미 먹은 음식인지 확인
                    if (hateMenu.get(name).contains(menu) || finalRecommenedMenu.get(name).contains(menu)) {
                        menu = "INVALID";
                        continue;
                    }

                    finalRecommenedMenu.get(name).add(menu);
                }
            }
            recommendedCategories.add(category);

        }
        outputView.printResult(names, finalRecommenedMenu);

    }


}
