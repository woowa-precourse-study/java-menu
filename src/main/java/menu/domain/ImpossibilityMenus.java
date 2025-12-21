package menu.domain;

import java.util.HashMap;
import java.util.Map;

public class ImpossibilityMenus {

    private final Map<Person, ImpossibilityMenu> impossibilityMenus;

    public ImpossibilityMenus() {
        this.impossibilityMenus = new HashMap<>();
    }

    public void addImpossibilityMenu(Person person, ImpossibilityMenu menus) {
        impossibilityMenus.put(person, menus);
    }

    public ImpossibilityMenu getImpossibilityMenu(Person person) {
        return impossibilityMenus.get(person);
    }
}
