package menu.factory;

import java.util.List;
import menu.domain.Person;

public class MenuFactory {

    public static Person createPerson(String name, List<String> menus) {
        return Person.from(name, menus);
    }
}
