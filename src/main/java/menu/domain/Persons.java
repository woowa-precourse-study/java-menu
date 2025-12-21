package menu.domain;

import java.util.List;
import menu.exception.ErrorCode;

public class Persons {

    public static final int MIN_PERSONS_COUNT = 2;
    public static final int MAX_PERSONS_COUNT = 5;

    private final List<Person> persons;

    public Persons(List<String> names) {
        validate(names);
        this.persons = names.stream()
                .map(Person::new)
                .toList();
    }

    private void validate(List<String> names) {
        if (names.size() < MIN_PERSONS_COUNT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MIN_PERSONS_COUNT.getMessage());
        }
        if (names.size() > MAX_PERSONS_COUNT) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MAX_PERSONS_COUNT.getMessage());
        }
    }

    public List<Person> getPersons() {
        return persons;
    }
}
