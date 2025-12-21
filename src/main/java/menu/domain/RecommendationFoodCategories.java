package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RecommendationFoodCategories {

    private static final int MAX_CATEGORY_COUNT = 5;
    private static final int MAX_CATEGORY_DUPLICATE = 2;

    private final List<FoodCategory> recommendationFoodCategories;

    public RecommendationFoodCategories() {
        List<FoodCategory> categories = new ArrayList<>();
        while (categories.size() < MAX_CATEGORY_COUNT) {
            FoodCategory category = FoodCategory.from(
                    Randoms.pickNumberInRange(FoodCategory.getFirstNumber(), FoodCategory.getLastNumber()));
            List<FoodCategory> foodCategories = categories.stream()
                    .filter(existingCategory -> existingCategory == category)
                    .toList();
            if (foodCategories.size() < MAX_CATEGORY_DUPLICATE) {
                categories.add(category);
            }
        }
        this.recommendationFoodCategories = categories;
    }

    public List<FoodCategory> getRecommendationFoodCategories() {
        return recommendationFoodCategories;
    }
}
