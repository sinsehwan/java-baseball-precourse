package controller;

import model.BaseballGameNumber;
import model.GameAnswerType;
import util.IntegerParser;
import util.RandomNumberGenerator;
import view.ErrorMessage;
import view.GameView;
import view.InputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class GameController {
    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    private RandomNumberGenerator randomNumberGenerator;
    private final GameView gameView;
    private final InputView inputView;
    private final BufferedReader br;

    public GameController() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.gameView = new GameView();
        this.inputView = new InputView(gameView);
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            new GameController().run();
        }
        catch (IOException e) {
            System.out.println(ErrorMessage.SYSTEM_IO_ERROR.getMsg());
        }
    }

    public void run() throws IOException {
        String gameEndUserResponse;

        do {
            gameEndUserResponse = playSingleGame();
        } while(Objects.equals(gameEndUserResponse, RESTART_COMMAND));

        if (!Objects.equals(gameEndUserResponse, EXIT_COMMAND)) {
            gameView.printErrorMsg(ErrorMessage.ABNORMAL_EXIT.getMsg());
            return;
        }

        gameView.printGameEndMsg();

        br.close();
        gameView.releaseResource();
    }

    public String playSingleGame() throws IOException {
        int answer = randomNumberGenerator.makeRand3digit();
        BaseballGameNumber answerNumber = new BaseballGameNumber(IntegerParser.toIntArray(answer));

        int userInput = -1;
        while (answer != userInput) {
            userInput = playTurn(answerNumber);
        }

        gameView.printSingleGameEndMsg();
        return br.readLine();
    }

    private int playTurn(BaseballGameNumber answerNumber) throws IOException {
        int userInput;
        gameView.printTurnMsg();
        userInput = inputView.getUserInput();

        BaseballGameNumber userNumber = new BaseballGameNumber(IntegerParser.toIntArray(userInput));

        gameView.printResult(userNumber.compare(answerNumber));
        return userInput;
    }
}
