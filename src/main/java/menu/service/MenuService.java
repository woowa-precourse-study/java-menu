package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;
import menu.exception.Validator;
import menu.util.RandomGenerator;

import java.util.*;

public class MenuService {

    public Map<String, List<String>> recommendMenu(List<String> names, Map<String, List<String>> hateMenu) {
        Map<String, List<String>> finalRecommenedMenu = new LinkedHashMap<>();
        Set recommendedCategories = new HashSet();
        // 월 ~ 금까지 메뉴 추천
        while (recommendedCategories.size() < 5) {
            int num = RandomGenerator.getRandomNumber();
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
                    menu = RandomGenerator.getRandomMenu(menus);
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
        return finalRecommenedMenu;
    }

}
