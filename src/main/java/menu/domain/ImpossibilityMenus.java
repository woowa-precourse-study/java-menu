package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ImpossibilityMenus {

    private final Map<Person, ImpossibilityMenu> impossibilityMenus;

    public ImpossibilityMenus() {
        this.impossibilityMenus = new LinkedHashMap<>();
    }

    public void addImpossibilityMenu(Person person, ImpossibilityMenu menus) {
        impossibilityMenus.put(person, menus);
    }

    public List<String> getImpossibilityMenu(Person person) {
        return impossibilityMenus.get(person).getImpossibilityMenus();
    }
}
