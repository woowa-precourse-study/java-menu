package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenusTest {

    Menus menus = Menus.INIT;

    @Test
    void 메뉴_추가하는_테스트() {
        //given
        String menu = "스시";
        //when
        Menus newMenu = menus.addMenu(menu);
        //then
        Assertions.assertThat(newMenu.getMenus())
                .hasSize(1)
                .contains(menu);
    }
}
