package menu.domain;

import java.util.List;

public class Person {
    private final String name;
    private final Menus hateMenus;

    private Person(String name, List<String> menus) {
        this.name = name;
        this.hateMenus = Menus.of(menus);
    }

    public String getName() {
        return name;
    }

    public boolean hasMenu(String menu) {
        return hateMenus.hasMenu(menu);
    }

    public static Person from(String name, List<String> menus) {
        return new Person(name, menus);
    }
}
