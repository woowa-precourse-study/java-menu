package menu.controller;

import menu.domain.Crew;
import menu.domain.CrewGroup;
import menu.service.Service;

import java.util.List;
import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final Service service;
    static final int MAX_RETRY = 10;

    public Controller(Service service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {

        CrewGroup crewGroup = doRetry(() ->{
            List<String> names=inputView.readCoach();
                    return service.getCrewGroup(names);
                }
        );

    }



    private <T> T doRetry(Supplier<T> action) {
        int retry = 0;
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                retry++;
                System.out.println(e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }


}

