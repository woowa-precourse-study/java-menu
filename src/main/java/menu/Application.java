//package menu;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import javax.swing.SwingUtilities;
//import menu.domain.Coach;
//import menu.domain.Menu;
//import menu.domain.RandomCategoryNumberGenerator;
//import menu.domain.RandomNumberGenerator;
//import menu.service.CategoryRecommendService;
//import menu.service.MenuRecommendService;
//import menu.view.InputView;
//import menu.view.OutputView;
//
//public class Application {
//    public static void main(String[] args) {
//        // TODO: 프로그램 구현
//        RandomNumberGenerator RandomCategoryNumberGenerator = new RandomCategoryNumberGenerator();
//        CategoryRecommendService categoryRecommendService = new CategoryRecommendService(RandomCategoryNumberGenerator);
//        MenuRecommendService menuRecommendService = new MenuRecommendService();
//        InputView inputView = new InputView();
//        OutputView outputView = new OutputView();
//
//
//        // 코치 이름 입력
//        outputView.printStartMessage();
//        String[] coachNames = inputView.readCoachNames();
//
//        // 카테고리 추천 돌리기
//        int[] categories = categoryRecommendService.recommendCategory();
//
//        List<String> categoryNames = categoryRecommendService.recommendCategoryList();
//
//
//        // 디버그 코드
////        System.out.println("카테고리 넘버 확인용");
////        for(int i =  0 ; i < categories.length; i++){
////            System.out.println( categories[i] );
////        }
////        System.out.println("카테고리 넘버 확인 끝");
//
//        // 디버그 코드
//        System.out.println("카테고리 ");
//        for(String categoryName : categoryNames) {
//            System.out.println(categoryName);
//        }
//
//
//
//        // 코치 정보 리스트
//        List<Coach> coachList = new ArrayList<>();
//
//        // 코치 수 만큼 반복
//        // 순서대로 계속 뽑음 그러니까 한마디로
//        // 한 코치당 한번 끝나는게 아니었음
//
//        for (String coachName : coachNames) {
//            System.out.println("코치이름 : " + coachName);
//            // 못 먹는 메뉴 입력 받기
//            String[] rejectedMenu = inputView.readRejectedMenu(coachName);
//
//            // 디버그 코드
//            // 못 먹는 메뉴 출력
//            System.out.println("못 먹는 메뉴 출력");
//            for (String rejectedMenuName : rejectedMenu) {
//                System.out.println(rejectedMenuName);
//            }
//            System.out.println("출력 완료");
//
//            // 메뉴 추천 정보를 저장하기 위한 새로운 리스트
//            List<String> recommendedMenuList = new ArrayList<>();
//            //
//            // 월,화,수,목,금 총 5회 메뉴 추천
//            for (int categoryNum : categories) {
//
//                // 카테고리에 해당하는 메뉴 리스트 조회
//                List<String> menus = Arrays.stream(Menu.values())
//                        .filter(val -> val.getId() == categoryNum)
//                        .findFirst()
//                        .orElse(null)
//                        .getMenu();
//
//                // 메뉴 중에서 랜덤 메뉴 추천
//                String recommendedMenu = menuRecommendService.recommendMenu(menus);
//                System.out.println(categoryNum + " 카테고리  음식 추천 "  + recommendedMenu);
//                // 메뉴에 저장
//                recommendedMenuList.add(recommendedMenu);
//            }
//
//            // 정보를 통해 코치 객체 생성
//            Coach coach = new Coach(coachName, recommendedMenuList);
//
//            // 리스트에 저장
//            coachList.add(coach);
//        }
//
//
//        List<String> categoryList = new ArrayList<>();
//        for(int categoryNum : categories) {
//            String category = Arrays.stream(Menu.values())
//                    .filter(val -> val.getId() == categoryNum)
//                    .findFirst()
//                    .orElse(null)
//                    .getCategory();
//            categoryList.add(category);
//        }
//
//        // 결과 출력 부
//        outputView.printResult();
//        outputView.printCategory(categoryList);
//        for(Coach coach : coachList) {
//            String name = coach.getName();
//            List<String> menu = coach.getRecommendedMenu();
//            outputView.printMenu(name, menu);
//        }
//        System.out.println();
//        outputView.printEndMessage();
//    }
//}
