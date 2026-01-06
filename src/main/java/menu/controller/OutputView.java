package menu.controller;


import menu.domain.Result;
import menu.service.ResultDto;

public class OutputView {
    public static void printResult(ResultDto dto){
        System.out.println("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf("[ 카테고리 | %s ]\n",String.join(" | ",dto.getCategory()));
        int idx=0;
        for (String name:dto.getNames()){
            System.out.printf("[ %s | %s ]\n",name,String.join(" | ",dto.getResults().get(idx)));
            idx++;
        }
        System.out.println("추천을 완료했습니다.");

    }
}
