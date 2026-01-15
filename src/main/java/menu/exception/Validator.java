package menu.exception;

public interface Validator {
    void validate(String input);


    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력할 수 없습니다.");
        }
    }

}
