package menu.domain;

import menu.util.RandomGenerator;

import java.util.*;

public class Coach {
    private final String name;
    private final List<String> hateMenu;
    private final List<String> finalRecommenedMenu=new ArrayList<>();

    public Coach(String name, List<String> hateMenu){
        this.name=name;
        this.hateMenu=hateMenu;
    }

    public boolean isValidFood(String menu){
        if (hateMenu.contains(menu) || finalRecommenedMenu.contains(menu)) {
            return false;
        }
        return true;
    }

    public String getName(){
        return name;
    }

    public void addRecommendFood(String menu){
        finalRecommenedMenu.add(menu);
    }

    public List<String> getFinalRecommenedMenu(){
        return List.copyOf(finalRecommenedMenu);
    }


}
