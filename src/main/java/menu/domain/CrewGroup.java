package menu.domain;

import menu.utils.RandomGenerator;

import java.util.*;

public class CrewGroup {
    private final List<Crew> crews=new ArrayList<>();

    public void add(Crew crew){
        crews.add(crew);
    }

    public void validateCrews() {
        if (crews.size() < 2 || crews.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지 가능합니다.");
        }
    }

    public List<String> getCrewNames() {
        List<String> names=new ArrayList<>();
        for (Crew crew:crews){
            names.add(crew.getName());
        }
        return names;
    }

    public Map<String,String> recommend(List<String> foods){
        Map<String,String> results=new LinkedHashMap<>();
        for (Crew crew:crews){
            while(true){
                String food = RandomGenerator.getRandomFood(foods);
                if (!crew.isHate(food)){
                    results.put(crew.getName(),food);
                    break;
                }
            }
        }
        return results;

    }

    public Crew findByName(String name){
        Optional<Crew> crew = crews.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();

        return crew.orElseThrow(
                () -> new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다.")
        );
    }





}
