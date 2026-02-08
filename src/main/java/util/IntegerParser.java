package util;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerParser {
    public static ArrayList<Integer> toIntArray(int number) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (number > 0) {
            arr.add(number % 10);
            number /= 10;
        }
        Collections.reverse(arr);

        return arr;
    }
}
