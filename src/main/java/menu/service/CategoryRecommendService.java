package menu.service;

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

            // 메뉴로 변경?
//            categories[i] = String.valueOf(random);
            categories[i] = random;
        }
        return categories;
    }
}
