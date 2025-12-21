package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachGroup {
    private final List<Coach> coaches;

    public CoachGroup(List<String> names, Map<String, List<String>> hateMenus){
        this.coaches = new ArrayList<>();
        for (String name : names) {
            this.coaches.add(new Coach(name, hateMenus.get(name)));
        }
    }

    public List<Coach> getCoaches() {
        return List.copyOf(coaches);
    }


    public Map<String,List<String>> getCoachGroupRecommendeFood(){
        Map<String,List<String>> result=new HashMap<>();
        for (Coach coach:coaches){
            result.put(coach.getName(), coach.getFinalRecommenedMenu());
        }

        if (result.isEmpty()){
            throw new RuntimeException("결과가 비어있습니다.");
        }
        return Map.copyOf(result);
    }


}
