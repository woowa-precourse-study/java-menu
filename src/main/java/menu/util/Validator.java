package menu.util;

import java.util.List;
import java.util.regex.Pattern;
import menu.constant.ErrorMessage;
import menu.domain.Menu;

public class Validator {
    private final static String NAME_REGEX = "^[ㄱ-ㅎ가-힣]{2,4}$";

    public static void checkNameType(String name){
        String[] names = name.split(",");
        for(String s : names){
            if(!Pattern.matches(NAME_REGEX,s)){
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_ERROR.getMessage());
            }
        }
    }

    public static void checkLength(List<String> names){
        if(names.isEmpty() || names.size() < 2){
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_ERROR.getMessage());
        }
    }

    public static boolean checkMenu(String menu){

        for(Menu m : Menu.values()){
            if(m.getMenu().stream().anyMatch(val -> val.equals(menu))){
                return true;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MENU_NOT_EXIST.getMessage());
    }
}
