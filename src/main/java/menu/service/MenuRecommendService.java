package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MenuRecommendService {

    public String recommendMenu(List<String> menus){
        String menu = Randoms.shuffle(menus).get(0);
        return menu;
    }
}
