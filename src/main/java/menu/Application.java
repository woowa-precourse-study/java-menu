package menu;

import menu.domain.RandomCategoryNumberGenerator;
import menu.domain.RandomNumberGenerator;
import menu.service.CategoryRecommendService;
import menu.service.MenuRecommendService;
import menu.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator RandomCategoryNumberGenerator = new RandomCategoryNumberGenerator();
        CategoryRecommendService categoryRecommendService = new CategoryRecommendService(RandomCategoryNumberGenerator);
        MenuRecommendService menuRecommendService = new MenuRecommendService();
        InputView inputView = new InputView();
        // 코치 이름 입력
        String[] coachNames = inputView.readCoachNames();

        // 카테고리 추천 돌리기
        int[] categories = categoryRecommendService.recommendCategory();

        // 코치 수 만큼 반복
        for(int i = 0 ; i < coachNames.length; i++) {
            // 못 먹는 메뉴 입력 받기
            String coachName = coachNames[i];
            String[] rejectedMenu = inputView.readRejectedMenu(coachName);

            //
            // 월,화,수,목,금 총 5회 메뉴 추천
            for(int j = 0 ; j < 5 ; j++){

                String recommendedMenu = menuRecommendService.recommendMenu(menus);

            }

        }

    }
}
