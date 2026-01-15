package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Result {
    private final String name;
    private final List<String> recommendedFood = new ArrayList<>();

    public Result(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(String food) {
        recommendedFood.add(food);
    }

    public boolean isAvailableFood(String food) {
        return !recommendedFood.contains(food);
    }

    public List<String> getRecommendedFood() {
        return recommendedFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
