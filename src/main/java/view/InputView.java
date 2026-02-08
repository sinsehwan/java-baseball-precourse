package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final int NUMBER_LENGTH = 3;
    private static final int INVALID_INPUT = -1;
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

            if (parsedInput != INVALID_INPUT) {
                return parsedInput;
            }

            gameView.printTurnMsg();
        }
    }

    private int parseUserInput(String rawInput) {
        if (!checkInputFormat(rawInput)) {
            return INVALID_INPUT;
        }

        return parseToPositiveInt(rawInput);
    }

    private boolean checkInputFormat(String rawInput) {
        if (!isValidLength(rawInput)) {
            return false;
        }

        if (rawInput.contains("0")) {
            gameView.printErrorMsg(ErrorMessage.CONTAINS_ZERO.getMsg());
            return false;
        }

        return true;
    }

    private int parseToPositiveInt(String rawInput) {
        try {
            int userInput = Integer.parseInt(rawInput);
            if (userInput <= 0) {
                gameView.printErrorMsg(ErrorMessage.NOT_POSITIVE.getMsg());
                return INVALID_INPUT;
            }
            return userInput;
        }
        catch (NumberFormatException e) {
            gameView.printErrorMsg(ErrorMessage.INVALID_INPUT_NUMBER.getMsg());
            return INVALID_INPUT;
        }

    }

    private boolean isValidLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            gameView.printErrorMsg(ErrorMessage.INVALID_INPUT_LENGTH.getMsg());
            return false;
        }
        return true;
    }
}
