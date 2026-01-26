package menu.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomMenuGenerator {

    public static String generateMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
