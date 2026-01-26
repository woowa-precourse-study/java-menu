package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public static Coaches newInstance() {
        return new Coaches();
    }

    public void addCoach(String coachName) {
        Coach coach = Coach.from(coachName);
        coaches.add(coach);
    }

    public Coach getCoach(String coachName) {
        for (Coach coach : coaches) {
            if (coach.getName().equals(coachName)) {
                return coach;
            }
        }
        throw new IllegalArgumentException();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
