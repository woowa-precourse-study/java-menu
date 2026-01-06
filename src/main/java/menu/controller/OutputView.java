package menu.controller;


import menu.domain.Result;

import java.util.List;

public class OutputView {
    public static void printResult(List<Result> results){
        System.out.println("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        for (Result result:results){
            System.out.printf("[ %s ]\n",String.join(",",result.getCategory()));
        }

    }
}
