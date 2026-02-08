package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final int NUMBER_LENGTH = 3;
    private final GameView gameView;
    private final BufferedReader br;

    public InputView(GameView gameView) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.gameView = gameView;
    }

    public int getUserInput() throws IOException {
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
}
