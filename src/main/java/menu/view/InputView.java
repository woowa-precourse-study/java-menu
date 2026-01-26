package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String COACH_NAME_REQUEST = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String REJECTED_MENUS_REQUEST = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public static String readCoachNames() {
        System.out.println(COACH_NAME_REQUEST);
        return Console.readLine();
    }

    public static String readRejectedMenus(String coachName) {
        System.out.printf(REJECTED_MENUS_REQUEST, coachName);
        return Console.readLine();
    }
}
