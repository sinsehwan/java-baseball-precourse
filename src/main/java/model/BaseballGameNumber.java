package model;

public class BaseballGameNumber {
    private int[] number;

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
