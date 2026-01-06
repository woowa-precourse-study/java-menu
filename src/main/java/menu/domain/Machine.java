package menu.domain;

import menu.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Machine {
    private final CrewGroup crewGroup;
    private final Results results;

    public Machine(CrewGroup crewGroup) {
        this.crewGroup = crewGroup;
        this.results = new Results();
    }

    public void todayRecommend(DayOfWeek dayOfWeek){
        int num = RandomGenerator.getRandomNumber();
        Category category = Category.fromNumber(num);
        while(true){
            if (results.isAvailable(category.getKorName())){
                List<String> foods = category.getFoods();
                Map<String,String> result = crewGroup.recommend(foods);
                results.add(new Result(category.getKorName(),result));
            }
        }
    }


}
