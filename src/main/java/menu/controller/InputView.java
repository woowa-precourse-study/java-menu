package menu.controller;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.Validator;
import menu.utils.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readCoach() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = readInput(List.of(
                Validator::validateNotBlank
        ));
        return Parser.splitBy(input, ",");
    }

    public List<String> readHateFood(String name) {
        System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
        try{
            String input = Console.readLine().trim();
            return Arrays.stream(input.split(",", -1))
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (NoSuchElementException e){
            return List.of();
        }
    }

    private String readInput(List<Validator> validators) {
        try {
            String input = Console.readLine().trim();
            for (Validator v : validators) {
                v.validate(input);
            }
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

    }
}