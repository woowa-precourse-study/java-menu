package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.RandomCategoryNumberGenerator;
import menu.domain.RandomNumberGenerator;
import menu.service.CategoryRecommendService;
import menu.service.MenuRecommendService;
import menu.util.InputHandler;
import menu.view.InputView;
import menu.view.OutputView;
import org.mockito.exceptions.misusing.CannotVerifyStubOnlyMock;

public class Application2 {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator RandomCategoryNumberGenerator = new RandomCategoryNumberGenerator();
        CategoryRecommendService categoryRecommendService = new CategoryRecommendService(RandomCategoryNumberGenerator);
        OutputView outputView = new OutputView();

        // 코치 이름 입력
        outputView.printStartMessage();
        List<String> coachNames = InputHandler.retry(InputView::readCoachNames);

        // 카테고리 추천 돌리기
        List<String> categoryNames = categoryRecommendService.recommendCategoryList();

        // 코치 정보 리스트
        List<Coach> coachList = new ArrayList<>();
        for(String coachName : coachNames) {
            List<String> rejectedMenu = InputView.readRejectedMenu(coachName);
            Coach coach = new Coach(coachName, rejectedMenu);
            coachList.add(coach);
        }

        // 요일(카테고리) 별로 반복
        for(String categoryName : categoryNames) {

            // 코치 별로 추천하기
            for(Coach coach : coachList) {

                // 카테고리 메뉴 조회
                List<String> menus = Arrays.stream(Menu.values())
                        .filter(val -> val.getCategory().equals(categoryName))
                        .findFirst()
                        .orElse(null)
                        .getMenu();

                while(true){
                    String recommendMenu = Randoms.shuffle(menus).get(0);
                    //이미 추천 한 경우
                    if(coach.getRejectedMenu().contains(recommendMenu)
                            || coach.getRecommendedMenu().contains(recommendMenu)){
                        continue;
                    }
                    coach.addRecommendedMenu(recommendMenu);
                    break;
                }
            }
        }


        // 결과 출력 부
        outputView.printResult();
        outputView.printCategory(categoryNames);
        for(Coach coach : coachList) {
            String name = coach.getName();
            List<String> menu = coach.getRecommendedMenu();
            outputView.printMenu(name, menu);
        }
        System.out.println();
        outputView.printEndMessage();
    }
}
