package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import menu.domain.FoodCategory;
import menu.domain.ImpossibilityMenu;
import menu.domain.ImpossibilityMenus;
import menu.domain.MenuBoard;
import menu.domain.Person;
import menu.domain.Persons;
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
        ImpossibilityMenus impossibilityMenus = getImpossibilityMenus(persons);
        List<FoodCategory> categories = new ArrayList<>();
        while (categories.size() < 5) {
            FoodCategory category = FoodCategory.from(Randoms.pickNumberInRange(1, 5));
            List<FoodCategory> foodCategories = categories.stream()
                    .filter(existingCategory -> existingCategory == category)
                    .toList();
            if (foodCategories.size() < 2) {
                categories.add(category);
            }
        }
        Map<Person, List<String>> recommendMenus = new LinkedHashMap<>();
        for (Person person : persons.getPersons()) {
            recommendMenus.put(person, new ArrayList<>());
        }
        for (FoodCategory category : categories) {
            for (Person person : persons.getPersons()) {
                while (true) {
                    List<String> impossibilityMenu = impossibilityMenus.getImpossibilityMenu(person);
                    String menu = MenuBoard.getMenusExcluding(category, impossibilityMenu);
                    if (!recommendMenus.get(person).contains(menu)) {
                        recommendMenus.get(person).add(menu);
                        break;
                    }
                }
            }
        }
        outputView.printRecommendationResult(categories, recommendMenus);
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

    private ImpossibilityMenus getImpossibilityMenus(Persons persons) {
        ImpossibilityMenus impossibilityMenus = new ImpossibilityMenus();
        for (Person person : persons.getPersons()) {
            ImpossibilityMenu menu = retryOnError(() -> getImpossibilityMenu(person));
            impossibilityMenus.addImpossibilityMenu(person, menu);
        }
        return impossibilityMenus;
    }

    private ImpossibilityMenu getImpossibilityMenu(Person person) {
        List<String> menus = inputView.readImpossibilityMenuName(person.getName());
        return new ImpossibilityMenu(menus);
    }
}
