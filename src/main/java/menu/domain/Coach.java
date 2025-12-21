package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<String> rejectedMenu;
    private List<String> recommendedMenu;

    public Coach(String name, List<String> rejectedMenu, List<String> recommendedMenu) {
        this.name = name;
        this.rejectedMenu = rejectedMenu;
        this.recommendedMenu = recommendedMenu;
    }
}
