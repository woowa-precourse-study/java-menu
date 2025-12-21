package menu;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.FoodCategory;
import menu.domain.ImpossibilityMenu;
import menu.domain.ImpossibilityMenus;
import menu.domain.MenuRecommender;
import menu.domain.Person;
import menu.domain.Persons;
import menu.domain.RecommendMenus;
import menu.domain.RecommendationFoodCategories;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendation {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendation(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartApplication();
        Persons persons = retryOnError(this::getPersons);
        MenuRecommender menuRecommender = getMenuRecommender(persons);

        RecommendationFoodCategories recommendationFoodCategories = new RecommendationFoodCategories();
        List<FoodCategory> categories = recommendationFoodCategories.getRecommendationFoodCategories();

        RecommendMenus recommendMenus = new RecommendMenus(persons);
        for (FoodCategory category : categories) {
            for (Person person : persons.getPersons()) {
                String menu = menuRecommender.recommendMenu(person, category, recommendMenus);
                recommendMenus.addMenu(person, menu);
            }
        }
        outputView.printRecommendationResult(categories, recommendMenus.getRecommendMenus());
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Persons getPersons() {
        List<String> personNames = inputView.readPersonNames();
        return new Persons(personNames);
    }

    private MenuRecommender getMenuRecommender(Persons persons) {
        ImpossibilityMenus impossibilityMenus = new ImpossibilityMenus();
        for (Person person : persons.getPersons()) {
            ImpossibilityMenu menu = retryOnError(() -> getImpossibilityMenu(person));
            impossibilityMenus.addImpossibilityMenu(person, menu);
        }
        return new MenuRecommender(impossibilityMenus);
    }

    private ImpossibilityMenu getImpossibilityMenu(Person person) {
        List<String> menus = inputView.readImpossibilityMenuName(person.getName());
        return new ImpossibilityMenu(menus);
    }
}
