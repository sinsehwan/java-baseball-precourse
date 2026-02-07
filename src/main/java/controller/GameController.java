package controller;

import model.BaseballGameNumber;
import model.GameAnswerType;
import util.RandomNumberGenerator;
import view.GameView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
            System.out.println("[ERROR]: System IO Error");
        }
    }

    public void run() throws IOException {
        int resultCode;

        do {
            resultCode = playSingleGame();
        } while(resultCode == 1);

        if (resultCode != 2) {
            System.out.println("[ERROR]: Abnormal Exit");
            return;
        }

        System.out.println("게임을 완전히 종료합니다.");

        br.close();
    }

    public int playSingleGame() throws IOException {
        int answer = randomNumberGenerator.makeRand3digit();

        int userInput = -1;
        while (answer != userInput) {
            gameView.printTurnMsg();
            userInput = getUserInput();
            BaseballGameNumber answerNumber = new BaseballGameNumber(toIntArray(answer));
            BaseballGameNumber userNumber = new BaseballGameNumber(toIntArray(userInput));

            GameAnswerType answerType = userNumber.compare(answerNumber);
            System.out.println(answerType.getAnswer());
        }

        gameView.printGameEndMsg();
        // 예외 처리 필요
        return Integer.parseInt(br.readLine());
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
        int userInput;

        try {
            userInput = Integer.parseInt(rawInput);

            if (isValid(NUMBER_LENGTH, rawInput)) {
                return userInput;
            }
        }
        catch (Exception e) {
            System.out.println("[ERROR]: Invalid Input Number");
            return -1;
        }
        return -1;
    }

    private boolean isValid(int numLength, String num) {
        return num.length() == numLength;
    }

    private ArrayList<Integer> toIntArray(int number) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (number > 0) {
            arr.add(number % 10);
            number /= 10;
        }

        return arr;
    }
}
