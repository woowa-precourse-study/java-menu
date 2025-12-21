package menu.controller;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.Validator;

import java.util.*;

public class InputView {
    static String PREFIX_ERROR = "[ERROR] ";
    static final int MAX_RETRY = 10;

    /**
     * 코치 이름을 입력받는다.
     */
    public List<String> readCoachName() {
        List<String> names = new ArrayList<>();
        System.out.println("점심 메뉴 추천을 시작합니다.\n코치의 이름을 입력해 주세요. (, 로 구분)");
        // 숫자 입력
        String nameInput = readInputWithRetry(List.of(
                Validator::validateNotBlank,
                input ->
                        Validator.validateNameLength(input, 2, 4),
                input ->
                        Validator.validateCoachMinNumber(input, 2),
                input ->
                        Validator.validateCoachMaxNumber(input, 5)
        ));

        names = List.of(nameInput.split(","));
        return names;
    }

    /**
     * 코치별 못먹는 음식을 입력받는다./
     */
    public Map<String, List<String>> readHateFood(List<String> names) {
        Map<String, List<String>> hateMenu = new LinkedHashMap<>();
        try {
            for (String name : names) {
                hateMenu.put(name, new ArrayList<>());

                System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
                String foodInput = readInputWithRetry(List.of(
                        input ->
                                Validator.validateFoodMaxNumber(input, 2)
                ));
                List<String> foods = List.of(foodInput.split(","));
                hateMenu.replace(name, foods);
            }
        } catch (NullPointerException e) {

        }
        return hateMenu;
    }


    private String readInput(List<Validator> validators) {
        String input = Console.readLine();
        System.out.println(input);
        for (Validator v : validators) {
            v.validate(input);
        }
        return input;
    }


    private String readInputWithRetry(List<Validator> validators) {
        int retry = 0;
        while (true) {
            try {
                return readInput(validators);
            } catch (IllegalArgumentException | NoSuchElementException e) {
                retry++;
                System.out.println(PREFIX_ERROR + e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }
}

