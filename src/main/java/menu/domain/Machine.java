package menu.domain;

import menu.utils.RandomGenerator;

import java.util.List;
import java.util.Map;

public class Machine {
    private final CrewGroup crewGroup;
    private final Results results;

    public Machine(CrewGroup crewGroup) {
        this.crewGroup = crewGroup;
        this.results = new Results();
    }

    public Category getAvailableCategory(int num) {
        Category category = Category.fromNumber(num);
        if (results.isAvailableCategory(category.getKorName())){
            results.addCategory(category.getKorName());
            return category;
        }
        throw new IllegalArgumentException("[ERROR] 카테고리 중복");
    }


    public void todayRecommend(List<String> foods) {
        for (Crew crew : crewGroup.getCrews()) {
            while (true) {
                String food = RandomGenerator.getRandomFood(foods);
                if (crew.isHate(food)) {
                    continue;
                }

                Result result = results.findByName(crew.getName());
                if (result.isAvailableFood(food)) {
                    result.add(food);
                    break;
                }
            }


        }
    }



    public List<String> getCrewNames(){
        return crewGroup.getCrewNames();
    }

    public List<List<String>> getResults() {
        return results.getResults();
    }

    public List<String> getCategories() {
        return results.getCategories();
    }
}
