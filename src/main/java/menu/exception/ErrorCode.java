package menu.exception;

import menu.domain.ImpossibilityMenu;
import menu.domain.Person;
import menu.domain.Persons;

public enum ErrorCode {

    INVALID_NAME("이름은 빈 칸일 수 없습니다"),
    INVALID_NAME_LENGTH(
            String.format("이름은 %d자 이상 %d자 이하이어야 합니다", Person.MIN_NAME_LENGTH, Person.MAX_NAME_LENGTH)
    ),
    INVALID_MIN_PERSONS_COUNT(
            String.format("코치는 최소 %d명 이상 입력해야 합니다.", Persons.MIN_PERSONS_COUNT)
    ),
    INVALID_MAX_PERSONS_COUNT(
            String.format("코치는 최대 %d명 이하로 입력해야 합니다.", Persons.MAX_PERSONS_COUNT)
    ),
    INVALID_MENU_NAME("존재하지 않는 메뉴 이름입니다."),
    INVALID_MAX_IMPOSSIBILITY_MENUS_COUNT(
            String.format("불가능한 메뉴는 최대 2개까지 지정할 수 있습니다.", ImpossibilityMenu.MAX_IMPOSSIBILITY_MENUS_COUNT)
    ),
    INVALID_NUMBER("해당 번호의 카테고리는 없습니다.");

    private static final String prefix = "[ERROR] ";

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
