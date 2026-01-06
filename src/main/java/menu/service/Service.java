package menu.service;

import menu.domain.Crew;
import menu.domain.CrewGroup;
import menu.domain.DayOfWeek;
import menu.domain.Machine;

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

    public void startRecommendMachine(CrewGroup crewGroup){
        DayOfWeek dayOfWeek=DayOfWeek.getStartOfWeek();
        Machine machine=new Machine(crewGroup);
        for (int i=1; i<=5;i++){
            machine.recommend(dayOfWeek);
        }
    }
}
