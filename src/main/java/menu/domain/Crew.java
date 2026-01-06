package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Crew {
    private final String name;
    private final List<String> hateFoods = new ArrayList<>();

    public Crew(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void addFood(List<String> foods) {
        if (foods.size()>2){
            throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 최대 2개까지 입력 가능합니다.");
        }
        Collections.addAll(foods);
    }

    public boolean isHate(String name) {
        return hateFoods.contains(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
