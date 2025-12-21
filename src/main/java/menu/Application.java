package menu;

import menu.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        // 코치 이름 입력
        String[] coachNames = inputView.readCoachNames();

        // 카테고리 추천 돌리기


        for(int i = 0 ; i < coachNames.length; i++) {
            // 못 먹는 메뉴 입력 받기
            String coachName = coachNames[i];
            String[] rejectedMenu = inputView.readRejectedMenu(coachName);

            //
        }

    }
}
