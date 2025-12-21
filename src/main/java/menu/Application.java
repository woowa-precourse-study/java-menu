package menu;

import camp.nextstep.edu.missionutils.Console;
import menu.exception.Validator;

import java.util.*;

public class Application {

    // ===== 상수 =====

    static String PREFIX_ERROR="[ERROR] ";
    static final int MAX_RETRY = 10;


    // ===== main / run =====

    public static void main(String[] args) {

        try{
            run();
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }


    static void run() {
        try{
            // 숫자 입력
            String nameInput = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    input ->
                            Validator.validateNameLength(input, 2, 4),
                    input ->
                            Validator.validateCoachNumber(input, 2)
            ));

            List<String> names = List.of(nameInput.split(","));


        } catch(IllegalArgumentException | NoSuchElementException e){ // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR+e.getMessage());
        }

    }

    /**
     * 입력 관련 메서드
     * 아래와 같이 검증들을 input 파라미터로 넣어준다.
     *
     *             String number = readInputWithRetry(List.of(
     *                     Validator::validateNotBlank,
     *                     Validator::validateNotNumber,
     *                     input -> Validator.validateRange(input, 1, 4),
     *                     input -> Validator.validateMaxLength(input, 4)
     *
     *             ));
     * **/

    static String readInput(List<Validator> validators) {
        String input = Console.readLine();
        for (Validator v : validators) {
            v.validate(input);
        }
        return input;
    }


    static String readInputWithRetry(List<Validator> validators) {
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

