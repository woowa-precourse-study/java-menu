package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
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

        // 코치 정보 리스트
        List<Coach> coachList = new ArrayList<>();

        // 코치 수 만큼 반복
        for (String coachName : coachNames) {
            // 못 먹는 메뉴 입력 받기
            String[] rejectedMenu = inputView.readRejectedMenu(coachName);
            List<String> recommendedMenuList = new ArrayList<>();
            //
            // 월,화,수,목,금 총 5회 메뉴 추천
            for (int categoryNum : categories) {

                List<String> menus = Arrays.stream(Menu.values())
                        .filter(val -> val.getId() == categoryNum)
                        .findFirst()
                        .orElse(null)
                        .getMenu();

                String recommendedMenu = menuRecommendService.recommendMenu(menus);
                recommendedMenuList.add(recommendedMenu);
            }

            // 정보를 통해 코치 객체 생성
            Coach coach = new Coach(coachName, recommendedMenuList);

            // 리스트에 저장
            coachList.add(coach);
        }


    }
}
