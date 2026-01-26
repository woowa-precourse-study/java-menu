package menu.service;

import java.util.List;
import menu.constant.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;
import menu.generator.RandomCategoryGenerator;
import menu.generator.RandomMenuGenerator;

public class MenuService {

    private Coaches coaches;

    public Coaches registerCoachNames(List<String> coachNames) {
        coaches = Coaches.newInstance();

        for (String coachName : coachNames) {
            coaches.addCoach(coachName);
        }

        return coaches;
    }

    public void registerRejectedMenus(String coachName, List<String> rejectedMenus) {
        Coach coach = coaches.getCoach(coachName);
        coach.addRejectedMenus(rejectedMenus);
    }

    public Recommendation getResult() {
        Recommendation recommendation = Recommendation.from(coaches);

        while (!recommendation.isDone()) { // 추천 끝났으면(추천 카테고리 항목이 5개이면)
            String category = RandomCategoryGenerator.generateCategory();
            if (recommendation.isPossible(category)) { // 2번 미만으로 추천 되었으면
                recommendation.addCategory(category); // 추천 카테고리 추가
                addRecommendedMenu(category); // 추천 메뉴 추가
            }
        }

        return recommendation;
    }

    private void addRecommendedMenu(String category) {
        for (Coach coach : coaches.getCoaches()) { // 코치별로 메뉴 추천
            addRecommendedMenuEachCoach(category, coach);
        }
    }

    private void addRecommendedMenuEachCoach(String category, Coach coach) {
        while (true) {
            List<String> candidateMenus = Category.fromName(category).getMenus(); // 카테고리에 맞는 메뉴 후보 가져오기
            String menu = RandomMenuGenerator.generateMenu(candidateMenus); // 후보 중 메뉴 하나 랜덤 선택

            if (coach.isPossible(menu)) { // 이미 추천했거나 못먹는 음식이라면
                coach.addRecommendedMenu(menu); // 메뉴 추가
                break;
            }
        }
    }
}
