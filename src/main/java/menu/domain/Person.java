package menu.domain;

import java.util.List;

public class Person {
    private final String name;
    private final Menus menus;

    public Person(String name, List<String> menus) {
        this.name = name;
        this.menus = Menus.of(menus);
    }
}
