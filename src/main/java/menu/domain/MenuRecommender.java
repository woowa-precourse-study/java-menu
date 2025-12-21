package menu.domain;

import java.util.List;
import menu.exception.ErrorMessage;

public class MenuRecommender {
    private final MenuBoard board;

    public MenuRecommender(MenuBoard board) {
        this.board = board;
    }

    public void isValidMenu(List<String> parseMenu) {
        if (board.hasMenus(parseMenu)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    public MenuRecommender addPerson(String name, List<String> menus) {
        return null;
    }
}
