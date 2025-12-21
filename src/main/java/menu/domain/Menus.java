package menu.domain;

import java.util.List;

public class Menus {
    private final List<String> menus;

    private Menus(List<String> menus) {
        this.menus = menus;
    }

    public static Menus of(List<String> menus) {
        return new Menus(menus);
    }

    public boolean hasMenu(String menu) {
        return menus.contains(menu);
    }
}
