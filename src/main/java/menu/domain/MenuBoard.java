package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import menu.exception.ErrorCode;

public class MenuBoard {

    private static final Map<FoodCategory, List<String>> menuBoard = Map.of(
            FoodCategory.JAPANESE, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
            FoodCategory.KOREAN, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
            FoodCategory.CHINESE, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
            FoodCategory.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
            FoodCategory.WESTERN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    );

    private MenuBoard() {
    }

    public static void validateMenuName(String menuName) {
        List<Boolean> isContains = menuBoard.values().stream()
                .map(menus -> menus.contains(menuName))
                .toList();
        if (!isContains.contains(true)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MENU_NAME.getMessage());
        }
    }

    public static String getMenusExcluding(FoodCategory category, List<String> impossibilityMenus) {
        List<String> menus = menuBoard.get(category);
        while (true) {
            String menu = Randoms.shuffle(menus).get(0);
            if (!impossibilityMenus.contains(menu)) {
                return menu;
            }
        }
    }
}
