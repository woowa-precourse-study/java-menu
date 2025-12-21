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

    public List<String> recommendCategoryList() {
        List<String> categoryList = new ArrayList<>();
        int[] status = new int[6];

        while(categoryList.size() < 5) {
            int random = randomNumberGenerator.generate();
            if(status[random] <2) {
                String category = Arrays.stream(Menu.values())
                        .filter(val -> val.getId() == random)
                        .findFirst()
                        .orElse(null)
                        .getCategory();
                categoryList.add(category);
            }
        }
        return categoryList;
    }

//    public List<String> recommendCategoryList() {
//        List<String> categoryList = new ArrayList<>();
//        int[] status = new int[5];
//
//        for(int i = 0 ; i < 5 ; i++){
//            int random = randomNumberGenerator.generate();
//            String category = Arrays.stream(Menu.values())
//                    .filter(val -> val.getId() == random)
//                    .findFirst()
//                    .orElse(null)
//                    .getCategory();
//            categoryList.add(category);
//        }
//        return categoryList;
//    }

}
