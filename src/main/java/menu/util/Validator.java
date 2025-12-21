package menu.util;

import java.util.regex.Pattern;

public class Validator {
    private final static String NAME_REGEX = "/^[ㄱ-ㅎ가-힣]{2,4}$/";

    public static void checkNameRegex(String name){
        if(Pattern.matches(name,NAME_REGEX)){
            throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자 입니다.");
        }
    }
}
