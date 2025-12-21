package menu.exception;

public enum ErrorMessage {
    EXCEED_VALID_COACH_COUNT("코치의 수가 2명 미만이거나 5명 초과입니다."),
    NOT_VALID_NAME("이름이 2글자 미만이거나 4글자 초과입니다."),
    DUPLICATE_NAME("코치의 이름이 중복입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
