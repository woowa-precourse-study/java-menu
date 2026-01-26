package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommendation {

    public static final int RECOMMENDED_MENUS_SIZE = 5;

    private final Coaches coaches;
    private final List<String> categories;

    private Recommendation(Coaches coaches) {
        this.categories = new ArrayList<>();
        this.coaches = coaches;
    }

    public static Recommendation from(Coaches coaches) {
        return new Recommendation(coaches);
    }

    public boolean isDone() {
        return categories.size() == RECOMMENDED_MENUS_SIZE;
    }

    public boolean isPossible(String category) {
        return Collections.frequency(categories, category) < 2;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public Coaches getCoaches() {
        return coaches;
    }

    public List<String> getCategories() {
        return categories;
    }
}
