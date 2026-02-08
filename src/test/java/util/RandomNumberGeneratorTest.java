package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @RepeatedTest(50)
    @DisplayName("난수 생성 시 3자리, 범위, 중복없음 체크")
    void makeRand3digit() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator();
        // when
        int number = generator.makeRand3digit();
        String numStr = String.valueOf(number);
        // then
        assertThat(number).isBetween(123, 999);
        assertThat(numStr).doesNotContain("0");

        Set<Character> digitSet = new HashSet<>();

        for (char c : numStr.toCharArray()) {
            digitSet.add(c);
        }
        assertThat(digitSet).hasSize(3);
    }
}
