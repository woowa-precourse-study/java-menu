package menu.domain;

import java.util.List;
import java.util.Map;

public class MenuBoard {
    private final Map<Category, Menus> categoryMenus;

    public MenuBoard(Map<Category, Menus> categoryMenus) {
        this.categoryMenus = categoryMenus;
    }

    public boolean hasMenus(List<String> parseMenu) {
        return parseMenu.stream()
                .anyMatch(this::hasMenu);
    }

    private boolean hasMenu(String menu) {
        return categoryMenus.values()
                .stream()
                .anyMatch(menus -> menus.hasMenu(menu));
    }

    public Menus getMenusWith(Category category) {
        return categoryMenus.get(category);
    }
}
