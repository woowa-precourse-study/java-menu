package menu.domain;

import menu.exception.ErrorCode;

public class Person {

    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 4;

    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NAME.getMessage());
        }
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
