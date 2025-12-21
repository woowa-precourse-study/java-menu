package menu.domain;

import java.util.Arrays;
import menu.exception.ErrorCode;

public enum FoodCategory {

    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식"),
    ;

    private final int number;
    private final String name;

    FoodCategory(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static FoodCategory from(int number) {
        return Arrays.stream(values())
                .filter(category -> category.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_NUMBER.getMessage()));
    }

    public static int getFirstNumber() {
        return Arrays.stream(values())
                .map(category -> category.number)
                .sorted()
                .toList()
                .get(0);
    }

    public static int getLastNumber() {
        return Arrays.stream(values())
                .map(category -> category.number)
                .sorted((o1, o2) -> o2 - o1)
                .toList()
                .get(0);
    }

    public String getName() {
        return name;
    }
}
