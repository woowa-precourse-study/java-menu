package menu.domain;

public class PersonWeekMenus {
    private final Person person;
    private final Menus menus;
    private final MenuGenerator generator;

    private PersonWeekMenus(Person person, Menus menus, MenuGenerator generator) {
        this.person = person;
        this.menus = menus;
        this.generator = generator;
    }

    public static PersonWeekMenus from(Person person, Menus menus, MenuGenerator generator) {
        return new PersonWeekMenus(person, menus, generator);
    }

    public PersonWeekMenus generateMenu(Menus categoryMenus) {
        String menu = generator.generateMenu(categoryMenus);

        while (menus.hasMenu(menu) || person.hasMenu(menu)) {
            menu = generator.generateMenu(categoryMenus);
        }

        Menus newMenus = menus.addMenu(menu);
        return new PersonWeekMenus(person, newMenus, generator);
    }

    public Person getPerson() {
        return person;
    }

    public Menus getMenus() {
        return menus;
    }
}
