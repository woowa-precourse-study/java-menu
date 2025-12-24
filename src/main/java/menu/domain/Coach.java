package menu.domain;

import menu.util.RandomGenerator;

import java.util.*;

public class Coach {
    private final List<String> names;
    private final Map<String, List<String>> hateMenu;
    private final Map<String, List<String>> finalRecommenedMenu;

    public Coach(List<String> names, Map<String, List<String>> hateMenu, Map<String, List<String>> finalRecommenedMenu){
        this.names=names;
        this.hateMenu=hateMenu;
        this.finalRecommenedMenu=finalRecommenedMenu;
    }

    public Map<String, List<String>> recommendCoachFood(String category){
        List<String> menus = Menu.getFoodsByCategory(category);

        for (String name : names) {
            String menu = "INVALID";
            if (!finalRecommenedMenu.containsKey(name)) {
                finalRecommenedMenu.put(name, new ArrayList<>());
            }
            confirmRecommendedFood(menu,menus,name);
        }

        return finalRecommenedMenu;
    }

    public void confirmRecommendedFood(String menu, List<String> menus, String name){
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


}
