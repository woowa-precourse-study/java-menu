package menu.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.exception.ErrorMessage;

public class InputParser {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_NAME_SIZE = 2;
    private static final int MAXIMUM_NAME_SIZE = 4;
    private static final int MINIMUM_COACH_SIZE = 2;
    private static final int MAXIMUM_COACH_SIZE = 5;

    public List<String> parseName(String input) {
        List<String> result = List.of(input.split(DELIMITER));
        validateNames(result);

        return result;
    }

    private void validateNames(List<String> result) {
        result.forEach(this::validateName);

        validateSize(result);
        duplicateName(result);
    }

    private void validateName(String name) {
        if (name.length() < MINIMUM_NAME_SIZE || name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NAME.getMessage());
        }
    }

    private void validateSize(List<String> result) {
        if (result.size() < MINIMUM_COACH_SIZE || result.size() > MAXIMUM_COACH_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_VALID_COACH_COUNT.getMessage());
        }
    }

    private void duplicateName(List<String> result) {
        Set<String> set = new HashSet<>(result);

        if (set.size() != result.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    public List<String> parseMenu(String input) {
        return List.of(input.split(DELIMITER));
    }
}
