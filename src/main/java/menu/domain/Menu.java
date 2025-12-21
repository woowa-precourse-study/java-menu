package menu.domain;

import java.util.*;

public enum Menu {
    JAPANESE("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식",List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식",List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시아",List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식",List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String category;
    private final List<String> foods;


    Menu(String category, List<String> foods) {
        this.category = category;
        this.foods = foods;
    }


    private static Map<Integer,Menu> categoryMap=new HashMap<>();
    private static Map<String,List<String>> foodMap=new HashMap<>();

    static{
        categoryMap=generateCategoryMap();
        foodMap=generateFoodMap();
    }

    private static Map<Integer,Menu> generateCategoryMap(){
        int i=1;
        Map<Integer,Menu> menus=new HashMap<>();
        for (Menu menu:Menu.values()){
            menus.put(i,menu);
            i++;
        }
        return menus;
    }


    private static Map<String,List<String>> generateFoodMap(){
        Map<String,List<String>> menus=new HashMap<>();
        for (Menu menu:Menu.values()){
            menus.put(menu.category,List.copyOf(menu.foods));
        }
        return menus;
    }

    public static String getCategoriesByNumber(int number) {
        return categoryMap.get(number).category;
    }

    public static List<String> getFoodsByCategory(String category) {
        return foodMap.get(category);
    }
}
