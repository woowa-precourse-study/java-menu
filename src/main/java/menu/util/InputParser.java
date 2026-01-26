package menu.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    private static List<String> parseToElements(String rawInput) {
        rawInput = rawInput.strip();

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static List<String> parseCoachNames(String rawInput) {
        Validator.validateCoachNameFormat(rawInput.strip());

        List<String> names = parseToElements(rawInput);

        Validator.validateUnique(names);
        Validator.validateCoachNames(names);

        return names;
    }

    public static List<String> parseRejectedMenus(String rawInput) {
        if (rawInput.isBlank()) {
            return List.of();
        }

        Validator.validateRejectedMenuFormat(rawInput.strip());

        List<String> menus = parseToElements(rawInput);

        Validator.validateUnique(menus);
        Validator.validateRejectedMenus(menus);

        return menus;
    }
}
