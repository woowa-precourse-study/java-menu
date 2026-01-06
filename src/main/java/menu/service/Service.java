package menu.service;

import menu.domain.*;
import menu.utils.RandomGenerator;

import java.util.List;

public class Service {

    public CrewGroup getCrewGroup(List<String> names) {
        CrewGroup group = new CrewGroup();
        for (String name: names){
            group.add(new Crew(name));
        }
        group.validateCrews();
        return group;
    }

    public ResultDto startRecommendMachine(CrewGroup crewGroup){
        DayOfWeek dayOfWeek=DayOfWeek.getStartOfWeek();
        Machine machine=new Machine(crewGroup);
        for (int i=1; i<=5;i++){
            Category category = getRandomCategory(machine);
            machine.todayRecommend(category.getFoods());
            dayOfWeek=dayOfWeek.getNext();
        }
        return new ResultDto(machine.getCrewNames(),machine.getCategories(),machine.getResults());
    }

    private Category getRandomCategory(Machine machine) {
        while(true){
            int num = RandomGenerator.getRandomNumber();
            try{
                return machine.getAvailableCategory(num);
            } catch(IllegalArgumentException e){

            }
        }
    }


}
