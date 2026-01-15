package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import menu.domain.Category;
import menu.domain.Crew;
import menu.domain.CrewGroup;
import menu.domain.Machine;
import menu.utils.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationTest extends NsTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @DisplayName("전체 기능 테스트")
    @Nested
    class AllFeatureTest {

        @Test
        void 기능_테스트() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
                final Executable executable = () -> {
                    runException("구구,제임스", "김밥", "떡볶이");

                    assertThat(output()).contains(
                            "점심 메뉴 추천을 시작합니다.",
                            "코치의 이름을 입력해 주세요. (, 로 구분)",
                            "구구(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "메뉴 추천 결과입니다.",
                            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                            "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
                            "[ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
                            "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
                            "추천을 완료했습니다."
                    );
                };

                assertRandomTest(executable,
                        Mocking.ofRandomNumberInRange(2, 5, 1, 3, 4),   // 숫자는 카테고리 번호를 나타낸다.
                        Mocking.ofShuffle(
                                // 월요일
                                List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),    // 제임스

                                // 화요일
                                List.of("스파게티", "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "피자", "파니니"),   // 구구
                                List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"),   // 제임스

                                // 수요일
                                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 구구
                                List.of("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 제임스

                                // 목요일
                                List.of("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 구구
                                List.of("짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 제임스

                                // 금요일
                                List.of("카오 팟", "팟타이", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),    // 구구
                                List.of("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")     // 제임스
                        )
                );
            });
        }
    }

    /**
     * 내가 작성한 테스트
     * **/

    @Test
    void 기능_리드미_예시_테스트() {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            final Executable executable = () -> {
                runException("토미,제임스,포코", "우동,스시", "뇨끼,월남쌈","마파두부,고추잡채");

                assertThat(output()).contains(
                        "점심 메뉴 추천을 시작합니다.",
                        "코치의 이름을 입력해 주세요. (, 로 구분)",
                        "토미(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "포코(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "메뉴 추천 결과입니다.",
                        "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                        "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]",
                        "[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]",
                        "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]",
                        "[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]",
                        "추천을 완료했습니다."
                );
            };

            assertRandomTest(executable,
                    Mocking.ofRandomNumberInRange(2, 2, 1, 3, 4),   // 숫자는 카테고리 번호를 나타낸다.
                    Mocking.ofShuffle(
                            // 월요일
                            List.of("쌈밥", "김치찌개", "김밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
                            List.of("된장찌개", "비빔밥", "김밥", "김치찌개", "쌈밥", "제육볶음", "칼국수", "불고기", "떡볶이"),
                            List.of("된장찌개", "불고기", "김밥", "김치찌개", "쌈밥", "제육볶음", "비빔밥", "칼국수", "떡볶이"),

                            // 화요일
                            List.of( "김치찌개", "쌈밥","김밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
                            List.of("비빔밥", "된장찌개", "김밥", "김치찌개", "쌈밥", "제육볶음", "칼국수", "불고기", "떡볶이"),
                            List.of("불고기", "된장찌개", "김밥", "김치찌개", "쌈밥", "제육볶음", "비빔밥", "칼국수", "떡볶이"),

                            // 수요일
                            List.of("미소시루","규동", "우동", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
                            List.of("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
                            List.of("하이라이스", "가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "라멘", "오코노미야끼"),

                            // 목요일
                            List.of("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
                            List.of("토마토 달걀볶음", "짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "고추잡채"),
                            List.of("탕수육", "토마토 달걀볶음", "짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "고추잡채"),

                            // 금요일
                            List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
                            List.of("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
                            List.of("나시고렝", "파인애플 볶음밥", "팟타이", "카오 팟", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
                    )
            );
        });
    }

    @Test
    void 못먹는음식_빈값_정상_테스트() {
        assertSimpleTest(() -> {
            run("토미,제임스,포코","김치찌개,김밥","","");
            assertThat(output()).contains("메뉴 추천 결과입니다.");
        });
    }


    @Test
    void 이름길이_예외_테스트() {
        assertSimpleTest(() -> {
            runException("구");
            assertThat(output()).contains("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        });
    }

    @Test
    void 코치명수_예외_테스트() {
        assertSimpleTest(() -> {
            runException("구구");
            assertThat(output()).contains("[ERROR] 코치는 최소 2명, 최대 5명까지 가능합니다.");
        });
    }


    @Test
    void getAvailableCategory_두번초과_카테고리_중복_예외_테스트(){
        CrewGroup crewGroup = new CrewGroup();
        crewGroup.add(new Crew("구일"));
        crewGroup.add(new Crew("구이"));
        crewGroup.add(new Crew("구삼"));

        Machine machine=new Machine(crewGroup);
        machine.getAvailableCategory(1);
        machine.getAvailableCategory(1);

        assertThatThrownBy(() -> machine.getAvailableCategory(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void fromNumber_추천할수없는_카테고리_예외_테스트(){
        assertThatThrownBy(() -> Category.fromNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음식_없는_예외_테스트() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포코","라면");
            assertThat(output()).contains("[ERROR] 존재하지 않는 음식입니다.");
        });
    }

    @Test
    void 음식_입력2개초과_예외_테스트() {
        assertSimpleTest(() -> {
            runException("토미,제임스,포코","김치찌개,김밥,쌈밥");
            assertThat(output()).contains("[ERROR] 못 먹는 음식은 최대 2개까지 입력 가능합니다.");
        });
    }



//    @Test
//    void 랜덤기능테스트_이거_공부하기(){
//        List<String> foods=List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
//        Mocking.ofShuffle(
//        RandomGenerator.getRandomFood(foods)
//    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    private static void assertRandomTest(
            final Executable executable,
            final Mocking... mockings
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                Arrays.stream(mockings).forEach(mocking -> mocking.stub(mock));
                executable.execute();
            }
        });
    }

    public static class Mocking<T> {

        /**
         * stubbing lambda verification 예시) () -> Randoms.pickNumberInList(anyList())
         */
        private final MockedStatic.Verification verification;

        // 반환할 첫 번째 값
        private final T value;

        /**
         * 첫 번째 값을 반환하고 나서 다음에 반환할 값들. 예를 들면, verification을 처음 실행하면 value를 반환하고 두 번째 실행하면 values[0]을
         * 반환한다.
         */
        private final T[] values;

        private Mocking(final MockedStatic.Verification verification,
                        final T value,
                        final T... values) {
            this.verification = verification;
            this.value = value;
            this.values = values;
        }

        public static Mocking ofRandomNumberInRange(final Integer value, final Integer... values) {
            return new Mocking(() -> Randoms.pickNumberInRange(anyInt(), anyInt()), value, values);
        }

        public static <T> Mocking ofShuffle(final List<T> value, final List<T>... values) {
            return new Mocking(() -> Randoms.shuffle(anyList()), value, values);
        }

        public <S> void stub(final MockedStatic<S> mock) {
            mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
        }
    }
}