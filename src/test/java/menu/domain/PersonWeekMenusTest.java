package menu.domain;

import java.util.List;
import menu.domain.menugenerator.SushiMenuGenerator;
import menu.factory.ApplicationFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonWeekMenusTest {

    ApplicationFactory factory = new ApplicationFactory();
    PersonWeekMenus personWeekMenus;
    MenuBoard menuBoard;

    @BeforeEach
    void setUp() {
        personWeekMenus = PersonWeekMenus.from(Person.from("제임스", List.of()), Menus.INIT, new SushiMenuGenerator());
        menuBoard = factory.initMenuBoard();
    }

    @Test
    void 메뉴_생성_테스트() {
        //given
        Menus categoryMenus = menuBoard.getMenusWith(Category.JAPANESE);
        //when
        PersonWeekMenus newPersonWeekMenus = personWeekMenus.generateMenu(categoryMenus);
        //then
        Menus menus = newPersonWeekMenus.getMenus();
        Assertions.assertThat(menus.getMenus())
                .hasSize(1)
                .contains("스시");
    }
}
