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

//    public String[] recommendCategory() {
//        String[] categories = new String[5];
//        for(int i = 0 ; i < 5 ; i++){
//            int random = randomNumberGenerator.generate();
//
//            String category = "";
//            if(random == 1) {
//                category = "JAPANESE";
//            }else if(random == 2) {
//                category = "KOREAN";
//            }else if(random == 3) {
//                category = "CHINA";
//            }else if(random == 4) {
//                category = "ASIAN";
//            }else{
//                category = "ITALIAN";
//            }
//            categories[i] = category;
//        }
//        return categories;
//    }
}
