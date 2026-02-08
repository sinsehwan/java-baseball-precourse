package util;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int makeRand3digit() {
        boolean[] isDuplicated = new boolean[10];

        int answer = 0;

        for (int i = 0; i < 3; i++) {
            answer *= 10;
            answer += getNonDuplicatedNumber(isDuplicated);
        }

        return answer;
    }

    private int getNonDuplicatedNumber(boolean[] isDuplicated) {
        while(true) {
            int randNum = random.nextInt(9) + 1;
            if (!isDuplicated[randNum]) {
                isDuplicated[randNum] = true;
                return randNum;
            }
        }
    }
}
