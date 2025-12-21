package menu.service;

import menu.domain.Coach;
import menu.domain.CoachGroup;
import menu.domain.Menu;
import menu.exception.Validator;
import menu.util.RandomGenerator;

import java.util.*;

public class MenuService {

    public Map<String, List<String>> recommendMenu(List<String> names, Map<String, List<String>> hateMenu) {
        List<String> recommendedCategories = new ArrayList<>();

        // 월 ~ 금까지 메뉴 추천
        CoachGroup coachGroup = new CoachGroup(names,hateMenu);
        while (recommendedCategories.size()<5) {
            int num = RandomGenerator.getRandomNumber();
            String category = Menu.getCategoriesByNumber(num);
            if (Collections.frequency(recommendedCategories, category)>=2){
                continue;
            }
            recommendedCategories.add(category);

            // 해당 카테고리의 음식 추천
            List<String> menus = Menu.getFoodsByCategory(category);
            for (Coach coach:coachGroup.getCoaches()){
                confirmRecommendedFood(coach, menus);
            }
        }
        return coachGroup.getCoachGroupRecommendeFood();
    }

    private void confirmRecommendedFood(Coach coach, List<String> menus) {
        while(true){
            String menu = RandomGenerator.getRandomMenu(menus);
            if (coach.isValidFood(menu)){
                coach.addRecommendFood(menu);
                return;
            }
        }
    }

}
