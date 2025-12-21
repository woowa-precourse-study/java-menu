package menu.service;

import menu.domain.Coach;
import menu.domain.CoachGroup;
import menu.domain.Menu;
import menu.util.RandomGenerator;

import java.util.*;

public class MenuService {

    public MenuDto recommendMenu(List<String> names, Map<String, List<String>> hateMenu) {
        List<Menu> recommendedCategories = new ArrayList<>();

        // 월 ~ 금까지 메뉴 추천
        CoachGroup coachGroup = new CoachGroup(names,hateMenu);
        while (recommendedCategories.size()<5) {
            Menu menu = Menu.fromNumber(RandomGenerator.getRandomNumber());
            if (Collections.frequency(recommendedCategories,  menu)>=2){
                continue;
            }
            recommendedCategories.add(menu);

            // 해당 카테고리의 음식 추천
            List<String> menus = menu.getFoods();
            for (Coach coach:coachGroup.getCoaches()){
                confirmRecommendedFood(coach, menus);
            }
        }
        return new MenuDto(recommendedCategories, coachGroup.getCoachGroupRecommendeFood());
    }

    private void confirmRecommendedFood(Coach coach, List<String> menus) {
        while(true){
            String food = RandomGenerator.getRandomMenu(menus);
            if (coach.isValidFood(food)){
                coach.addRecommendFood(food);
                return;
            }
        }
    }

}
