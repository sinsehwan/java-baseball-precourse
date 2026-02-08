package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameAnswerTypeTest {

    @Test
    @DisplayName("메시지 - 낫싱")
    void nothingMessage() {
        GameAnswerType result = new GameAnswerType(0, 0);
        assertThat(result.getAnswer()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("메시지 - 스트라이크")
    void strikeMessage() {
        GameAnswerType result = new GameAnswerType(2, 0);
        assertThat(result.getAnswer()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("메시지 - 볼")
    void ballMessage() {
        GameAnswerType result = new GameAnswerType(0, 2);
        assertThat(result.getAnswer()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("메시지 - 스트라이크 & 볼")
    void strikeBallMessage() {
        GameAnswerType result = new GameAnswerType(2, 1);
        assertThat(result.getAnswer()).isEqualTo("2스트라이크 1볼");
    }



}
