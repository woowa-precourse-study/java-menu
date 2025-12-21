package menu.domain.menugenerator;

import menu.domain.MenuGenerator;
import menu.domain.Menus;

public class SushiMenuGenerator implements MenuGenerator {
    @Override
    public String generateMenu(Menus menus) {
        return "스시";
    }
}
