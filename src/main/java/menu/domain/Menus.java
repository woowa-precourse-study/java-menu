package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    public static final Menus INIT = Menus.of(List.of());

    private final List<String> menus;

    private Menus(List<String> menus) {
        this.menus = menus;
    }

    public boolean hasMenu(String menu) {
        return menus.contains(menu);
    }

    public List<String> getMenus() {
        return List.copyOf(menus);
    }

    public Menus addMenu(String menu) {
        List<String> newMenus = new ArrayList<>(menus);
        newMenus.add(menu);

        return new Menus(newMenus);
    }

    public static Menus of(List<String> menus) {
        return new Menus(menus);
    }
}
