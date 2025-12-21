package menu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Menu;
import menu.domain.RandomNumberGenerator;

public class CategoryRecommendService {
    private final RandomNumberGenerator randomNumberGenerator;

    public CategoryRecommendService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int[] recommendCategory() {
        int[] categories = new int[5];
        for(int i = 0 ; i < 5 ; i++){
            int random = randomNumberGenerator.generate();
            categories[i] = random;
        }
        return categories;
    }

    public List<String> recommendCategoryList() {
        List<String> categoryList = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            int random = randomNumberGenerator.generate();
            String category = Arrays.stream(Menu.values())
                    .filter(val -> val.getId() == random)
                    .findFirst()
                    .orElse(null)
                    .getCategory();
            categoryList.add(category);
        }
        return categoryList;
    }


}
