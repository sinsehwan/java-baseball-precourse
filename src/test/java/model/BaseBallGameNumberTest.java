package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameNumberTest {

    @Test
    @DisplayName("3 스트라이크 체크")
    void strike3() {
        // given
        BaseballGameNumber computer = new BaseballGameNumber(new ArrayList<>(List.of(1, 2, 3)));
        BaseballGameNumber user = new BaseballGameNumber(new ArrayList<>(List.of(1, 2, 3)));
        // when
        GameAnswerType result = user.compare(computer);
        // then
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getAnswer()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("3볼 체크")
    void ball3() {
        // given
        BaseballGameNumber computer = new BaseballGameNumber(new ArrayList<>(List.of(2, 3, 1)));
        BaseballGameNumber user = new BaseballGameNumber(new ArrayList<>(List.of(1, 2, 3)));
        // when
        GameAnswerType result = user.compare(computer);
        // then
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(3);
        assertThat(result.getAnswer()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("낫싱 체크")
    void nothing() {
        // given
        BaseballGameNumber computer = new BaseballGameNumber(new ArrayList<>(List.of(1, 2, 3)));
        BaseballGameNumber user = new BaseballGameNumber(new ArrayList<>(List.of(4, 5, 6)));
        // when
        GameAnswerType result = user.compare(computer);
        // then
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getAnswer()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void strike1ball1() {
        // given
        BaseballGameNumber computer = new BaseballGameNumber(new ArrayList<>(List.of(1, 2, 3)));
        BaseballGameNumber user = new BaseballGameNumber(new ArrayList<>(List.of(1, 3, 7)));
        // when
        GameAnswerType result = user.compare(computer);
        // then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getAnswer()).isEqualTo("1스트라이크 1볼");
    }
}
