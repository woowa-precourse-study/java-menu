package menu;

import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MenuRecommendation menuRecommendation = new MenuRecommendation(inputView, outputView);
        menuRecommendation.run();
    }
}
