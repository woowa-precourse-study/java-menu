package menu.domain;

public class MenuRecommender {

    private final ImpossibilityMenus impossibilityMenus;

    public MenuRecommender(ImpossibilityMenus impossibilityMenus) {
        this.impossibilityMenus = impossibilityMenus;
    }

    public String recommendMenu(Person person, FoodCategory category, RecommendMenus recommendMenus) {
        ImpossibilityMenu impossibilityMenu = impossibilityMenus.getImpossibilityMenu(person);
        String menu = null;
        boolean recommended = true;
        while (recommended) {
            menu = MenuBoard.getMenusExcluding(category, impossibilityMenu);
            recommended = recommendMenus.containsMenu(person, menu);
        }
        return menu;
    }
}
