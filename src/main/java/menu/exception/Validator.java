package menu.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Validator {
    void validate(String input);

    /**
     * 검증 관련 메서드
     * 검증이 추가되면 아래에 추가하기
     **/

    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    static void validateNameLength(String input, int minLength, int maxLength) {
        List<String> inputs = List.of(input.split(","));
        for (String name : inputs) {
            if (name.length() > maxLength || name.length() < minLength) {
                throw new IllegalArgumentException("코치 이름은 최소 " + minLength + "글자, 최대 " + maxLength + "글자여야 합니다.");
            }
        }
    }

    static void validateCoachMinNumber(String input, int minLength) {
        List<String> inputs = List.of(input.split(","));
        if (inputs.size() < minLength) {
            throw new IllegalArgumentException("코치는 최소 " + minLength + "명 이상 입력해야 합니다.");
        }
    }

    static void validateCoachMaxNumber(String input, int maxLength) {
        List<String> inputs = List.of(input.split(","));
        if (inputs.size() > maxLength) {
            throw new IllegalArgumentException("코치는 최대 " + maxLength + "명 이하 입력해야 합니다.");
        }
    }

    static void validateFoodMaxNumber(String input, int maxLength) {
        List<String> inputs = List.of(input.split(","));
        if (inputs.size() > maxLength) {
            throw new IllegalArgumentException("못 먹는 음식은 " + maxLength + "개 이하 입력해야 합니다.");
        }
    }

    static void validateRange(int input, int min, int max) {
        if (input < min || input > max) {
            throw new IllegalArgumentException(min + "부터 " + max + " 사이의 숫자만 가능합니다.");
        }
    }

    static void validateCoachNameIsUnique(String input){
        List<String> inputs = List.of(input.split(","));
        Set<String> coachNameSet = new HashSet<>(inputs);
        if (coachNameSet.size() != inputs.size()){
            throw new IllegalArgumentException("코치 이름은 중복될 수 없습니다.");
        }
    }


}

