package menu.domain;

import java.util.List;
import menu.exception.ErrorMessage;

public class MenuRecommender {
    private final MenuBoard board;
    private final CategoryGenerator categoryGenerator;
    private final WeekMenus weekMenus;

    public MenuRecommender(MenuBoard board, CategoryGenerator categoryGenerator, WeekMenus weekMenus) {
        this.board = board;
        this.categoryGenerator = categoryGenerator;
        this.weekMenus = weekMenus;
    }

    public void isValidMenu(List<String> parseMenu) {
        if (parseMenu.isEmpty() || parseMenu.get(0).isBlank()) {
            return;
        }

        if (!board.hasMenus(parseMenu)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MENU.getMessage());
        }
    }

    public MenuRecommender addPerson(Person person) {
        WeekMenus newWeekMenus = weekMenus.addPerson(person);

        return new MenuRecommender(board, categoryGenerator, newWeekMenus);
    }

    public MenuRecommender recommendMenu() {
        Category category = categoryGenerator.generate();

        while (weekMenus.validateCategoryCount(category)) {
            category = categoryGenerator.generate();
        }

        WeekMenus newWeekMenus = weekMenus.addNewMenu(category, board);
        return new MenuRecommender(board, categoryGenerator, newWeekMenus);
    }

    public WeekMenus getWeekMenus() {
        return weekMenus;
    }
}
