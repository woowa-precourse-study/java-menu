package menu.service;

import menu.domain.Coach;
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
            Coach coach=new Coach(names,hateMenu,finalRecommenedMenu);
            finalRecommenedMenu=coach.recommendCoachFood(category);
            recommendedCategories.add(category);

        }
        return finalRecommenedMenu;
    }

}
