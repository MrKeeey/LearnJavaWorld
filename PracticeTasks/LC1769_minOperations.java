package PracticeTasks;

import java.util.Arrays;

public class LC1769_minOperations {

    //faster
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        int sumBalls = 0;

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                sumBalls++;
                result[0] += i;
            }
        }
        if (sumBalls == 0) return result;

        int left = boxes.charAt(0) == '1' ? 1 : 0;
        int right = sumBalls - left;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] - right + left;
            if (boxes.charAt(i) == '1') {
                left++;
                if (right > 0) {
                    right--;
                }
            }
        }

        return result;
    }

    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i)=='1') {
                for (int j = 0; j < n; j++) {
                    result[j] += Math.abs(i - j);
                }
            }
        }

        return result;
    }

    public int[] minOperations3(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (boxes.charAt(j)=='1') {
                    result[i] += Math.abs(i - j);
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (boxes.charAt(j)=='1') {
                    result[i] += Math.abs(i - j);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC1769_minOperations().minOperations("001011")));
        System.out.println(Arrays.toString(new LC1769_minOperations().minOperations2("001011")));
        System.out.println(Arrays.toString(new LC1769_minOperations().minOperations3("001011")));
    }
}
