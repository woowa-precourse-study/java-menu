package menu.controller;

import menu.domain.Menu;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printResult(List<String> names, List<String> recommendedCategories, Map<String, List<String>> recommendedFoods){
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
//        System.out.println("[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]");
        System.out.printf("[ 카테고리 | %s ]\n", String.join(" | ", recommendedCategories));

        for (String name : names) {
            System.out.printf("[ %s | %s ]\n", name, String.join(" | ", recommendedFoods.get(name)));
        }
        System.out.println("추천을 완료했습니다.");
    }
}
