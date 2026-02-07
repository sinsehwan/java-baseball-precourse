package model;

import java.util.ArrayList;
import java.util.Objects;

public class BaseballGameNumber {
    private ArrayList<Integer> number;

    public BaseballGameNumber(ArrayList<Integer> arr) {
        this.number = arr;
    }

    public GameAnswerType compare(BaseballGameNumber other) {
        int strikes = calStrikes(other);
        int balls = calBalls(strikes, other);

        return new GameAnswerType(strikes, balls);
    }

    private int calStrikes(BaseballGameNumber other) {
        int strike = 0;
        for (int i = 0; i < this.number.size(); i++) {
            if(isStrike(i, other)) {
                strike += 1;
            }
        }

        return strike;
    }

    private int calBalls(int strikes, BaseballGameNumber other) {
        return this.calMatchCount(other) - strikes;
    }

    private boolean isStrike(int index, BaseballGameNumber other) {
        return Objects.equals(this.number.get(index), other.number.get(index));
    }

    private int calMatchCount(BaseballGameNumber other) {
        boolean[] originFlags = this.getNumberFlags();
        boolean[] otherFlags = other.getNumberFlags();

        int matchCount = 0;

        for (int i = 0; i < originFlags.length; i++) {
            matchCount = getMatchCount(originFlags, i, otherFlags, matchCount);
        }

        return matchCount;
    }

    private static int getMatchCount(boolean[] originFlags, int i, boolean[] otherFlags, int matchCount) {
        if(originFlags[i] && otherFlags[i]) {
            matchCount += 1;
        }
        return matchCount;
    }

    private boolean[] getNumberFlags() {
        boolean[] flags = new boolean[10];

        for (int num : this.number) {
            flags[num] = true;
        }

        return flags;
    }

}
