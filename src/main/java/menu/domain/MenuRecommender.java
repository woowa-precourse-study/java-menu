package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuRecommender {

    private final ImpossibilityMenus impossibilityMenus;

    public MenuRecommender(ImpossibilityMenus impossibilityMenus) {
        this.impossibilityMenus = impossibilityMenus;
    }

    public String recommendMenu(Person person, FoodCategory category, Map<Person, List<String>> recommendMenus) {
        ImpossibilityMenu impossibilityMenu = impossibilityMenus.getImpossibilityMenu(person);
        String menu = null;
        boolean recommended = true;
        while (recommended) {
            menu = MenuBoard.getMenusExcluding(category, impossibilityMenu);
            recommended = recommendMenus.get(person).contains(menu);
        }
        return menu;
    }
}
