package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerParserTest {
    @Test
    @DisplayName("정수 리스트 변환")
    void toIntArray() {
        // given
        int input = 456;
        // when
        List<Integer> result = IntegerParser.toIntArray(input);
        // then
        assertThat(result)
                .hasSize(3)
                .containsExactly(4, 5, 6);
    }
}
