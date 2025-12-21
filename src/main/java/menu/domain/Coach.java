package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> rejectedMenu;
    private List<String> recommendedMenu = new ArrayList<String>();

    public Coach(String name, List<String> rejectedMenu) {
        this.rejectedMenu = rejectedMenu;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getRejectedMenu() {
        return rejectedMenu;
    }

    public List<String> getRecommendedMenu() {
        return recommendedMenu;
    }

    public void addRecommendedMenu(String recommendedMenu) {
        this.recommendedMenu.add(recommendedMenu);
    }
}
