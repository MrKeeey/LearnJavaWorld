package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC564_nearestPalindromic {
    public static void main(String[] args) {
        System.out.println(nearestPalindromic("991"));
    }

    public static String nearestPalindromic(String n) {
        int length = n.length();
        boolean isEven = length % 2 == 0;
        int count = length % 2 == 0 ? length / 2 - 1 : length / 2;
        long leftHalf = Long.parseLong(n.substring(0, count + 1));

        List<Long> possiblePalindrome = new ArrayList<>();
        possiblePalindrome.add(addRightHalf(leftHalf, isEven));
        possiblePalindrome.add(addRightHalf(leftHalf - 1, isEven));
        possiblePalindrome.add(addRightHalf(leftHalf + 1, isEven));
        possiblePalindrome.add((long) Math.pow(10, length - 1) - 1);
        possiblePalindrome.add((long) Math.pow(10, length) + 1);

        long diff = Long.MAX_VALUE;
        long result = 0;
        long originallyNum = Long.parseLong(n);
        for (long candidate : possiblePalindrome) {
            if (candidate == originallyNum) continue;
            if (Math.abs(candidate - originallyNum) < diff) {
                diff = Math.abs(candidate - originallyNum);
                result = candidate;
            } else if (Math.abs(candidate - originallyNum) == diff) {
                result = Math.min(result, candidate);
            }
        }

        return String.valueOf(result);
    }

    private static long addRightHalf(long leftHalf, boolean isEven) {
        long result = leftHalf;
        if (!isEven) leftHalf /= 10;

        while (leftHalf > 0) {
            result = result * 10 + (leftHalf % 10);
            leftHalf /= 10;
        }

        return result;
    }
}
