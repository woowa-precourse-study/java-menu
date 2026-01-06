package menu.domain;

import java.util.Map;
import java.util.Objects;

public class Result {
    private final String category;
    private final Map<String,String> recommendedFood;

    public Result(String category, Map<String, String> recommendedFood) {
        this.category = category;
        this.recommendedFood = recommendedFood;
    }

    public String getCategory() {
        return category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(category, result.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }
}
