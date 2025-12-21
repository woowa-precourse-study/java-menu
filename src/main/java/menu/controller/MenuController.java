package menu.controller;

import static java.lang.String.format;
import static menu.controller.PrintMessage.INFO;
import static menu.controller.PrintMessage.INPUT_MENU;
import static menu.controller.PrintMessage.INPUT_NAME;
import static menu.view.InputView.readMenu;
import static menu.view.OutputView.printError;
import static menu.view.OutputView.printPrompt;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.MenuRecommender;
import menu.view.InputView;

public class MenuController {
    private final InputParser parser;
    private MenuRecommender recommender;

    public MenuController(InputParser parser, MenuRecommender recommender) {
        this.parser = parser;
        this.recommender = recommender;
    }

    public void run() {
        printPrompt(INFO);

        List<String> names = readNames();
        readMenus(names);

    }

    private void readMenus(List<String> names) {
        for (String name : names) {
            List<String> menus = retryOnError(() -> {
                printPrompt(format(INPUT_MENU, name));
                String menu = readMenu();

                List<String> parseMenu = parser.parseMenu(menu);
                recommender.isValidMenu(parseMenu);

                return parseMenu;
            });

            recommender = recommender.addPerson(name, menus);
        }
    }

    private List<String> readNames() {
        return retryOnError(() -> {
            printPrompt(INPUT_NAME);
            String names = InputView.readName();

            return parser.parseName(names);
        });
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private void retryOnError(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }
}
