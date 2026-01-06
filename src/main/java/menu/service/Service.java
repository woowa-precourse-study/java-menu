package menu.service;

import menu.domain.*;

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

    public List<Result> startRecommendMachine(CrewGroup crewGroup){
        DayOfWeek dayOfWeek=DayOfWeek.getStartOfWeek();
        Machine machine=new Machine(crewGroup);
        for (int i=1; i<=5;i++){
            machine.todayRecommend(dayOfWeek);
        }
        return machine.getResults();
    }
}
