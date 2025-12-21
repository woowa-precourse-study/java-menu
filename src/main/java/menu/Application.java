package menu;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;
import menu.exception.Validator;

import java.util.*;

public class Application {

    // ===== 상수 =====

    static String PREFIX_ERROR="[ERROR] ";
    static final int MAX_RETRY = 10;


    // ===== main / run =====

    public static void main(String[] args) {

        try{
            run();
        } catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }


    static void run() {
        List<String> names = new ArrayList<>();
        Map<String,List<String>> hateMenu=new LinkedHashMap<>();
        Map<String,List<String>> finalRecommenedMenu=new LinkedHashMap<>();

        try{
            System.out.println("점심 메뉴 추천을 시작합니다.\n코치의 이름을 입력해 주세요. (, 로 구분)");
            // 숫자 입력
            String nameInput = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    input ->
                            Validator.validateNameLength(input, 2, 4),
                    input ->
                            Validator.validateCoachMinNumber(input, 2),
                    input ->
                            Validator.validateCoachMaxNumber(input, 5)
            ));

            names = List.of(nameInput.split(","));

            // 두번째 입력하기


            for (String name: names){
                System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n",name);
                String foodInput = readInputWithRetry(List.of(
                        input ->
                                Validator.validateFoodMaxNumber(input, 2)
                ));
                List<String> foods = List.of(foodInput.split(","));
                hateMenu.put(name,foods);
            }



        } catch(IllegalArgumentException | NoSuchElementException e){ // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR+e.getMessage());
        }

        Set recommendedCategories=new HashSet();
        // 월 ~ 금까지 메뉴 추천
        while(recommendedCategories.size()<5){
            int num=Randoms.pickNumberInRange(1, 5);
            Validator.validateRange(num,1,5);
            String category = Menu.getCategoriesByNumber(num);
            if (recommendedCategories.contains(category)){
                continue;
            }

            // 해당 카테고리의 음식 추천

            List<String> menus=Menu.getFoodsByCategory(category);

            for (String name:names){
                String menu="INVALID";
                while(menu!="INVALID"){
                    menu = Randoms.shuffle(menus).get(0);
                    // 해당 코치가 싫어하는 음식인지 확인
                    if (hateMenu.get(name).contains(menu)){
                        menu="INVALID";
                        continue;
                    }
                }
                if (!finalRecommenedMenu.containsKey(name)){
                    finalRecommenedMenu.put(name,new ArrayList<>());
                }
                finalRecommenedMenu.get(name).add(menu);
            }


            recommendedCategories.add(category);


        }



        System.out.println("메뉴 추천 결과입니다.");

        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");



    }



    /**
     * 입력 관련 메서드
     * 아래와 같이 검증들을 input 파라미터로 넣어준다.
     *
     *             String number = readInputWithRetry(List.of(
     *                     Validator::validateNotBlank,
     *                     Validator::validateNotNumber,
     *                     input -> Validator.validateRange(input, 1, 4),
     *                     input -> Validator.validateMaxLength(input, 4)
     *
     *             ));
     * **/

    static String readInput(List<Validator> validators) {
        String input = Console.readLine();
        for (Validator v : validators) {
            v.validate(input);
        }
        return input;
    }


    static String readInputWithRetry(List<Validator> validators) {
        int retry = 0;
        while (true) {
            try {
                return readInput(validators);
            } catch (IllegalArgumentException | NoSuchElementException e) {
                retry++;
                System.out.println(PREFIX_ERROR + e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }


}

