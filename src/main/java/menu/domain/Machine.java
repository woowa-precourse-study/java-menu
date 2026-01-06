package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private final CrewGroup crewGroup;
    private final List<Result> results=new ArrayList<>();

    public Machine(CrewGroup crewGroup) {
        this.crewGroup = crewGroup;
    }

    public void recommend(DayOfWeek dayOfWeek){

    }


}
