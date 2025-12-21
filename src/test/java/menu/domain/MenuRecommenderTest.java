package menu.domain;

import java.util.List;
import menu.factory.ApplicationFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRecommenderTest {
    ApplicationFactory factory = new ApplicationFactory();
    MenuRecommender recommender = factory.menuRecommender();

    @Test
    void 메뉴_추천기에_사람을_추가하는_테스트() {
        //given
        Person person = Person.from("제임스", List.of());
        //when
        MenuRecommender newRecommender = recommender.addPerson(person);
        //then
        WeekMenus weekMenus = newRecommender.getWeekMenus();
        Assertions.assertThat(weekMenus.getPersonWeekMenus())
                .hasSize(1);
    }
}
