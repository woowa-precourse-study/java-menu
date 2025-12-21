package menu.service;

import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuDto{
    private final List<String> recommendedCategories;
    private final Map<String, List<String>> recommendedFoods;

    public MenuDto(List<Menu> categories, Map<String, List<String>> foods) {
        this.recommendedCategories = new ArrayList<>();
        for (Menu menu:categories){
            recommendedCategories.add(menu.getCategory());
        }
        this.recommendedFoods = foods;
    }

    public List<String> getRecommendedCategories(){
        return recommendedCategories;
    }

    public Map<String, List<String>> getRecommendedFoods(){
        return recommendedFoods;
    }
}
