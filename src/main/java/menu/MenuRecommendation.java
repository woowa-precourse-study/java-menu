package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import menu.domain.FoodCategory;
import menu.domain.ImpossibilityMenu;
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
        List<ImpossibilityMenu> impossibilityMenus = new ArrayList<>();
        for (Person person : persons.getPersons()) {
            ImpossibilityMenu impossibilityMenu = retryOnError(() -> {
                List<String> menus = inputView.readImpossibilityMenuName(person.getName());
                return new ImpossibilityMenu(person, menus);
            });
            impossibilityMenus.add(impossibilityMenu);
        }
        List<FoodCategory> categories = new ArrayList<>();
        while (categories.size() < 5) {
            FoodCategory category = FoodCategory.from(Randoms.pickNumberInRange(1, 5));
            int count = 0;
            for (FoodCategory existingCategory : categories) {
                if (existingCategory == category) {
                    count++;
                }
            }
            if (count < 2) {
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
                    String menu = MenuBoard.getMenusExcluding(category, impossibilityMenus.stream()
                            .filter(im -> im.getPerson().equals(person))
                            .findFirst()
                            .orElseThrow()
                            .getImpossibilityMenus());
                    if (!recommendMenus.get(person).contains(menu)) {
                        recommendMenus.get(person).add(menu);
                        break;
                    }
                }
            }
        }
        outputView.printRecommendationResult(categories, recommendMenus);
    }

    private Persons getPersons() {
        List<String> personNames = inputView.readPersonNames();
        return new Persons(personNames);
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
}
