package menu.constant;

public enum ErrorMessage {
    COACH_NAME_ERROR("코치 이름은 한글, 최소 2글자, 최대 4글자 입니다."),
    COACH_COUNT_ERROR("코치는 최소 2명 이상 입력해야 합니다."),
    MENU_NOT_EXIST("목록에 존재하지 않는 메뉴입니다.")
    ;

    private String message;

    private static String prefix = "[ERROR]";

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
