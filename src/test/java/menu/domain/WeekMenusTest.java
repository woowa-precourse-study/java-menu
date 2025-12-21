package menu.domain;

import java.util.List;
import menu.domain.menugenerator.SushiMenuGenerator;
import menu.factory.ApplicationFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekMenusTest {
    ApplicationFactory factory = new ApplicationFactory();
    MenuBoard board = factory.initMenuBoard();

    WeekMenus weekMenus = WeekMenus.from(List.of(), List.of(), new SushiMenuGenerator());


    @Test
    void 카테고리에_따른_메뉴를_생성해_추가하는_테스트() {
        //given
        Person person = Person.from("제임스", List.of());
        //when
        WeekMenus newWeekMenus = weekMenus.addPerson(person);
        WeekMenus finalWeekMenus = newWeekMenus.addNewMenu(Category.JAPANESE, board);
        //then
        Assertions.assertThat(finalWeekMenus.getPersonWeekMenus())
                .hasSize(1);
    }
}
