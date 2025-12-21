package menu.domain;

import java.util.List;
import menu.exception.ErrorCode;

public class ImpossibilityMenu {

    public static final int MAX_IMPOSSIBILITY_MENUS_COUNT = 2;

    private final List<String> impossibilityMenus;

    public ImpossibilityMenu(List<String> impossibilityMenus) {
        validate(impossibilityMenus);
        impossibilityMenus.forEach(MenuBoard::validateMenuName);
        this.impossibilityMenus = impossibilityMenus;
    }

    private void validate(List<String> impossibilityMenus) {
        if (impossibilityMenus.size() > MAX_IMPOSSIBILITY_MENUS_COUNT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MAX_IMPOSSIBILITY_MENUS_COUNT.getMessage());
        }
    }

    public List<String> getImpossibilityMenus() {
        return impossibilityMenus;
    }
}
