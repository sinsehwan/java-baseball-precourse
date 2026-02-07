package controller;

import model.BaseballGameNumber;
import model.GameAnswerType;
import util.RandomNumberGenerator;
import view.ErrorMessage;
import view.GameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class GameController {
    private static final int NUMBER_LENGTH = 3;
    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    private RandomNumberGenerator randomNumberGenerator;
    private GameView gameView;
    private BufferedReader br;

    public GameController() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.gameView = new GameView();
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
        BaseballGameNumber answerNumber = new BaseballGameNumber(toIntArray(answer));

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
        userInput = getUserInput();

        BaseballGameNumber userNumber = new BaseballGameNumber(toIntArray(userInput));

        gameView.printResult(userNumber.compare(answerNumber));
        return userInput;
    }

    private int getUserInput() throws IOException {
        while (true) {
            String rawInput = br.readLine();
            int parsedInput = parseUserInput(rawInput);

            if (parsedInput != -1) {
                return parsedInput;
            }

            gameView.printTurnMsg();
        }
    }

    private int parseUserInput(String rawInput) {
        int userInput = -1;

        if (!isValidLength(rawInput)) {
            return userInput;
        }

        if (rawInput.contains("0")) {
            gameView.printErrorMsg(ErrorMessage.CONTAINS_ZERO.getMsg());
            return userInput;
        }

        try {
            userInput = Integer.parseInt(rawInput);

            if (userInput <= 0) {
                gameView.printErrorMsg(ErrorMessage.NOT_POSITIVE.getMsg());
                return -1;
            }
        }
        catch (Exception e) {
            gameView.printErrorMsg(ErrorMessage.INVALID_INPUT_NUMBER.getMsg());
        }
        return userInput;
    }

    private boolean isValidLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            gameView.printErrorMsg(ErrorMessage.INVALID_INPUT_LENGTH.getMsg());
            return false;
        }
        return true;
    }


    private ArrayList<Integer> toIntArray(int number) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (number > 0) {
            arr.add(number % 10);
            number /= 10;
        }
        Collections.reverse(arr);

        return arr;
    }
}
