package model;

import java.util.ArrayList;
import java.util.Objects;

public class BaseballGameNumber {
    private ArrayList<Integer> number;

    public BaseballGameNumber(ArrayList<Integer> arr) {
        this.number = arr;
    }


    public GameAnswerType compare(BaseballGameNumber other) {
        int strikes = 0;
        int balls = 0;

        boolean[] isDuplicated = new boolean[10];

        for (int i = 0; i < number.size(); i++) {
            if (isDuplicated[number.get(i)]) {
                continue;
            }

            if (Objects.equals(number.get(i), other.number.get(i))) {
                strikes += 1;
            }
            else if (isContains(other.number.get(i))){
                balls += 1;
            }

            isDuplicated[number.get(i)] = true;
        }

        return new GameAnswerType(strikes, balls);
    }

    private boolean isContains(int num) {
        for (int n : this.number) {
            if (isSame(n, num)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(int num1, int num2) {
        return num1 == num2;
    }

}
