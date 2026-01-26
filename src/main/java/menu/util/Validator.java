package menu.util;

import java.util.HashSet;
import java.util.List;
import menu.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^ *[가-힣a-zA-Z]+ *(, *[가-힣a-zA-Z]+ *)*$";
    public static final int COACH_COUNT_MIN = 2;
    public static final int COACH_COUNT_MAX = 5;
    public static final int REJECTED_MENU_COUNT_MAX = 2;

    private Validator() {}

    public static void validateCoachNameFormat(String input) {
        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateCoachNames(List<String> names) {
        if (names.size() < COACH_COUNT_MIN) {
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_MIN_ERROR.getErrorMessage());
        }

        if (names.size() > COACH_COUNT_MAX) {
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_MAX_ERROR.getErrorMessage());
        }
    }

    public static void validateRejectedMenuFormat(String input) {
        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateRejectedMenus(List<String> menus) {
        if (menus.size() > REJECTED_MENU_COUNT_MAX) {
            throw new IllegalArgumentException(ErrorMessage.REJECTED_MENU_COUNT_ERROR.getErrorMessage());
        }
    }

    public static void validateUnique(List<String> inputs) {
        if (inputs.size() != new HashSet<>(inputs).size()) {
            throw new IllegalArgumentException(ErrorMessage.UNIQUE_ERROR.getErrorMessage());
        }
    }
}
