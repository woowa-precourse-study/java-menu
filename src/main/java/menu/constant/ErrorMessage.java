package menu.constant;

public enum ErrorMessage {

    FORMAT_ERROR("입력 형식이 올바르지 않습니다."),
    COACH_COUNT_MIN_ERROR("코치는 최소 2명 이상 입력해야 합니다."),
    COACH_COUNT_MAX_ERROR("코치는 5명 이하로 입력해야 합니다."),
    COACH_NAME_LENGTH_ERROR("코치의 이름은 2자 이상 4자 이하여야 합니다."),
    REJECTED_MENU_COUNT_ERROR("못 먹는 메뉴의 개수는 2개 이하여야 합니다"),
    NO_EXIST_MENU_ERROR("없는 메뉴입니다."),
    UNIQUE_ERROR("중복된 값이 있습니다."),
    NO_EXIST_CATEGORY_ERROR("없는 카테고리 입니다."),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
