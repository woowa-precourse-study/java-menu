package menu.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.FoodCategory;
import menu.domain.Person;

public class OutputView {

    public void printStartApplication() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printRecommendationResult(List<FoodCategory> categories, Map<Person, List<String>> menus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        String categoryLine = String.join(" | ",
                categories.stream().map(FoodCategory::getName).collect(Collectors.toList()));
        System.out.println("[ 카테고리 | " + categoryLine + " ]");

        for (Person person : menus.keySet()) {
            String menuLine = String.join(" | ", menus.get(person));
            System.out.println("[ " + person.getName() + " | " + menuLine + " ]");
        }

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
