package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;
import menu.service.MenuService;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        OutputView.printStart();

        Coaches coaches = registerCoachNames();
        for (Coach coach : coaches.getCoaches()) {
            registerRejectedMenus(coach.getName());
        }

        Recommendation result = menuService.getResult();
        OutputView.printResult(result);
    }

    private void registerRejectedMenus(String coachName) {
        retryOnError(() -> {
            String readRejectedMenus = InputView.readRejectedMenus(coachName);
            List<String> rejectedMenus = InputParser.parseRejectedMenus(readRejectedMenus);

            menuService.registerRejectedMenus(coachName, rejectedMenus);
        });
    }

    private Coaches registerCoachNames() {
        return retryOnError(() -> {
            String readCoachNames = InputView.readCoachNames();
            List<String> coachNames = InputParser.parseCoachNames(readCoachNames);

            return menuService.registerCoachNames(coachNames);
        });
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void retryOnError(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
