package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.menugenerator.RandomMenuGenerator;

public class WeekMenus {
    public static final WeekMenus INIT = WeekMenus.from(List.of(), List.of(), new RandomMenuGenerator());

    private final List<Category> categories;
    private final List<PersonWeekMenus> personWeekMenus;
    private final MenuGenerator generator;

    private WeekMenus(List<Category> categories, List<PersonWeekMenus> personWeekMenus, MenuGenerator generator) {
        this.categories = categories;
        this.personWeekMenus = personWeekMenus;
        this.generator = generator;
    }

    public static WeekMenus from(List<Category> categories, List<PersonWeekMenus> personWeekMenus,
                                 MenuGenerator generator) {
        return new WeekMenus(categories, personWeekMenus, generator);
    }

    public WeekMenus addPerson(Person person) {
        List<PersonWeekMenus> newWeekMenus = new ArrayList<>(personWeekMenus);

        PersonWeekMenus newPerson = PersonWeekMenus.from(person, Menus.INIT, generator);
        newWeekMenus.add(newPerson);

        return new WeekMenus(categories, newWeekMenus, generator);
    }

    public List<Category> getCategories() {
        return List.copyOf(categories);
    }

    public List<PersonWeekMenus> getPersonWeekMenus() {
        return List.copyOf(personWeekMenus);
    }

    public boolean validateCategoryCount(Category newCategory) {
        long count = categories.stream()
                .filter(category -> category.equals(newCategory))
                .count();

        return count > 2;
    }

    public WeekMenus addNewMenu(Category category, MenuBoard board) {
        List<Category> addCategories = addCategory(category);

        Menus menus = board.getMenusWith(category);

        List<PersonWeekMenus> collect = personWeekMenus.stream()
                .map(weekMenu -> weekMenu.generateMenu(menus))
                .collect(Collectors.toList());

        return new WeekMenus(addCategories, collect, generator);
    }

    private List<Category> addCategory(Category category) {
        List<Category> newCategories = new ArrayList<>(categories);

        newCategories.add(category);

        return newCategories;
    }
}
