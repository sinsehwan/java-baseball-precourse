package view;

import java.io.*;

public class GameView {
    private static String turnMsg = "숫자를 입력해주세요 : ";
    private static String gameEndMsg = "3개의 숫자를 모두 맞히셨습니다! 게임 끝\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void printTurnMsg() throws IOException {
        bw.write(turnMsg);
    }

    public void printGameEndMsg() throws IOException {
        bw.write(gameEndMsg);
    }

    public void releaseResource() throws IOException {
        bw.close();
    }
}
