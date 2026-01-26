package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.constant.ErrorMessage;
import menu.constant.Category;

public class Coach {

    public static final int COACH_NAME_LENGTH_MIN = 2;
    public static final int COACH_NAME_LENGTH_MAX = 4;

    private final String name;
    private List<String> rejectedMenus;
    private final List<String> recommendedMenus;

    private Coach(String name) {
        this.name = name;
        this.rejectedMenus = new ArrayList<>();
        this.recommendedMenus = new ArrayList<>();
    }

    public static Coach from(String name) {
        validate(name);

        return new Coach(name);
    }

    private static void validate(String name) {
        if (name.length() < COACH_NAME_LENGTH_MIN || name.length() > COACH_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void addRejectedMenus(List<String> rejectedMenus) {
        for (String rejectedMenu : rejectedMenus) {
            validateExistence(rejectedMenu);
        }
        this.rejectedMenus = new ArrayList<>(rejectedMenus);
    }

    private void validateExistence(String rejectedMenu) {
        for (Category menu : Category.values()) {
            List<String> menus = menu.getMenus();
            if (menus.contains(rejectedMenu)) {
                return;
            }
        }

        throw new IllegalArgumentException(ErrorMessage.NO_EXIST_MENU_ERROR.getErrorMessage());
    }

    public boolean isPossible(String menu) {
        return !recommendedMenus.contains(menu) && !rejectedMenus.contains(menu);
    }

    public void addRecommendedMenu(String menu) {
        this.recommendedMenus.add(menu);
    }
}
