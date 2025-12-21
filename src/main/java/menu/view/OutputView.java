package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menus;
import menu.domain.Person;
import menu.domain.PersonWeekMenus;
import menu.domain.WeekMenus;

public class OutputView {
    public static void printPrompt(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printResult(WeekMenus weekMenus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        printCategories(weekMenus);
        printPersonMenus(weekMenus);

        System.out.println("추천을 완료했습니다.");
    }

    private static void printCategories(WeekMenus weekMenus) {
        List<Category> categories = weekMenus.getCategories();

        StringBuilder builder = new StringBuilder("[ 카테고리 | ");
        String category = categories.stream()
                .map(Category::getName)
                .collect(Collectors.joining(" | "));

        builder.append(category).append(" ]");

        System.out.println(builder);
    }

    private static void printPersonMenus(WeekMenus weekMenus) {
        List<PersonWeekMenus> personWeekMenus = weekMenus.getPersonWeekMenus();

        for (PersonWeekMenus personWeekMenu : personWeekMenus) {
            Person person = personWeekMenu.getPerson();
            Menus menu = personWeekMenu.getMenus();

            StringBuilder builder = new StringBuilder("[ ");
            builder.append(person.getName()).append(" | ");

            List<String> menus = menu.getMenus();
            String printMenu = String.join(" | ", menus);

            builder.append(printMenu).append(" ]");

            System.out.println(builder);
        }
    }
}
