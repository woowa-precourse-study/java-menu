package menu.controller;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    InputParser parser = new InputParser();

    @ParameterizedTest
    @ValueSource(strings = {"잭,제임스", "아아오오오오,이이"})
    void 코치의_이름은_2이상_4이하_여야한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parseName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"제임스", "잭콜,제임스,브라운,그린,래빗,캡틴"})
    void 코치의_사람수는_2이상_5이하_여야한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parseName(input));
    }
}
