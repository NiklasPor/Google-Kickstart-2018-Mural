import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int max = in.nextInt();

            System.out.println("Case #" + i + ": " + evaluate(in.next()));
        }
    }

    private static long evaluate(String wall) {
        int options = (int)Math.round(wall.length() / 2.0);
        List<Integer> sections = wall.chars().map(i -> i - '0').boxed().collect(Collectors.toList());

        long result = 0;
        long value = 0;

        for (int i = 0; i < options; i++) {
            value += sections.get(i);
        }

        for (int i = 0; i < wall.length() - options; i++) {
            if (value > result) {
                result = value;
            }

            value -= sections.get(i);
            value += sections.get(i + options);
        }

        if (value > result) {
            result = value;
        }

        return result;
    }
}