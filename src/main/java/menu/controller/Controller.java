package menu.controller;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Category;
import menu.domain.Crew;
import menu.domain.CrewGroup;
import menu.service.Service;
import menu.utils.Parser;

import java.util.List;
import java.util.NoSuchElementException;
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
        CrewGroup crewGroup = doRetry(() -> {
                    List<String> names = inputView.readCoach();
                    return service.getCrewGroup(names);
                }
        );

        doRetry(() -> {
                    for (String name : crewGroup.getCrewNames()) {
                        List<String> foods = inputView.readHateFood(name);
                        for (String food:foods){
                            Category.isAvailableFood(food);
                        }
                        Crew crew = crewGroup.findByName(name);
                        crew.addFood(foods);
                    }
                    return crewGroup;
                }
        );
        OutputView.printResult(service.startRecommendMachine(crewGroup));

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

