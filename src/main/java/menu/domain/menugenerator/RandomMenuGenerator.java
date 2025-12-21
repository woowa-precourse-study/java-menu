package menu.domain.menugenerator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuGenerator;
import menu.domain.Menus;

public class RandomMenuGenerator implements MenuGenerator {
    @Override
    public String generateMenu(Menus menus) {
        return Randoms.shuffle(menus.getMenus()).get(0);
    }
}
