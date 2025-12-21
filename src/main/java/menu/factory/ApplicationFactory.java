package menu.factory;

import menu.controller.InputParser;
import menu.controller.MenuController;
import menu.domain.MenuBoard;
import menu.domain.MenuRecommender;

public class ApplicationFactory {

    public MenuController controller() {
        return new MenuController(inputParser(), menuRecommender());
    }

    private InputParser inputParser() {
        return new InputParser();
    }

    private MenuRecommender menuRecommender() {
        return new MenuRecommender(initMenuBoard());
    }

    private MenuBoard initMenuBoard() {
        return null;
    }
}
