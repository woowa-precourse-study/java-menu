package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import menu.util.Validator;

public class InputView {
    public static List<String> readCoachNames(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        try{
            String inputNames = Console.readLine();
            Validator.checkNameType(inputNames);

            List<String> names = Arrays.asList(inputNames.split(","));
            Validator.checkLength(names);
            System.out.println();
            return names;

        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static List<String> readRejectedMenu(String name){
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        try{
            String inputMenu = Console.readLine();
            List<String> names = Arrays.asList(inputMenu.split(","));
            for(String menu : names){
                Validator.checkMenu(menu);
            }
            System.out.println();
            return names;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
