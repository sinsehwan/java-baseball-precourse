package view;

import model.GameAnswerType;

import java.io.*;

public class GameView {
    private static String TURN_MSG = "숫자를 입력해주세요 : ";
    private static String SINGLE_GAME_END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static String GAME_END_MSG = "게임을 완전히 종료합니다.";

    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printTurnMsg() throws IOException {
        bw.write(TURN_MSG);
        bw.flush();
    }

    public void printResult(GameAnswerType result) throws IOException {
        bw.write(result.getAnswer());
        bw.newLine();
        bw.flush();
    }

    public void printSingleGameEndMsg() throws IOException {
        bw.write(SINGLE_GAME_END_MSG);
        bw.flush();
    }

    public void printGameEndMsg() throws IOException {
        bw.write(GAME_END_MSG);
        bw.flush();
    }

    public void releaseResource() throws IOException {
        bw.close();
    }
}
