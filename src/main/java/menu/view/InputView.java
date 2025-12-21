package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readCoachNames(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");

        String inputNames = Console.readLine();
        List<String> names = Arrays.asList(inputNames.split(","));
        System.out.println();
        return names;
    }

    public List<String> readRejectedMenu(String name){
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String inputMenu = Console.readLine();
        List<String> names = Arrays.asList(inputMenu.split(","));
        System.out.println();
        return names;
    }
}
