package menu.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecommendMenus {

    private final Map<Person, List<String>> recommendMenus;

    public RecommendMenus(Persons persons) {
        this.recommendMenus = new LinkedHashMap<>();
        for (Person person : persons.getPersons()) {
            recommendMenus.put(person, new ArrayList<>());
        }
    }

    public boolean containsMenu(Person person, String menu) {
        return recommendMenus.get(person).contains(menu);
    }

    public void addMenu(Person person, String menu) {
        recommendMenus.get(person).add(menu);
    }

    public Map<Person, List<String>> getRecommendMenus() {
        return recommendMenus;
    }
}
