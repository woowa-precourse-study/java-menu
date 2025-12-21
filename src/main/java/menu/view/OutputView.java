package menu.view;

import java.util.List;

public class OutputView {

    public void printStartMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printCategory(List<String> categories){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | "+ String.join(" | ", categories) + " ]");
    }

    public void printMenu(String name, List<String> menus){
        System.out.println("[ " + name + " | " + String.join(" | ", menus) + " ]");
    }

    public void printResult(){
        System.out.println("메뉴 추천 결과입니다.");
    }

    public void printEndMessage(){
        System.out.println("추천을 완료했습니다.");
    }
}
