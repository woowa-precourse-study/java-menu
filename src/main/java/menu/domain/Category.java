package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String name;
    private final int value;

    Category(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static Category valueOf(int value) {
        return Arrays.stream(Category.values())
                .filter(category -> category.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값입니다."));
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
