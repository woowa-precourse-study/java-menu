package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readPersonNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> names = List.of(scanner.nextLine()
                .split(","));
        System.out.println();
        return names;
    }

    public List<String> readImpossibilityMenuName(String name) {
        String format = String.format("%s(이)가 못 먹는 메뉴를 입력해 주세요.", name);
        System.out.println(format);
        List<String> menus = List.of(scanner.nextLine()
                .split(","));
        System.out.println();
        return menus;
    }
}
