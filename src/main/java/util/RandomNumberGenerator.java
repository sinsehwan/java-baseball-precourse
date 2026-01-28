package util;

import java.util.Random;

public class RandomNumberGenerator {
    private Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int makeRand3digit() {
        int answer = 0;

        for (int i = 0; i < 3; i++) {
            answer *= 10;
            answer += random.nextInt(9) + 1;
        }

        return answer;
    }
}
