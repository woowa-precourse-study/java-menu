package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;

public class OutputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String RESULT = "메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_RESULT = "[ 카테고리 | %s ]\n";
    private static final String MENU_RESULT = "[ %s | %s ]\n";
    private static final String FINISH_MESSAGE = "추천을 완료했습니다.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printResult(Recommendation result) {
        System.out.println(RESULT);

        List<String> categories = result.getCategories();
        System.out.printf(CATEGORY_RESULT, String.join(" | ", categories.toArray(new String[0])));

        Coaches coaches = result.getCoaches();
        for (Coach coach : coaches.getCoaches()) {
            System.out.printf(MENU_RESULT, coach.getName(), String.join(" | ", coach.getRecommendedMenus().toArray(new String[0])));
        }

        System.out.println(FINISH_MESSAGE);
    }
}
