package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2094_findEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        int[] countDigits = new int[10];
        for (int digit : digits) {
            countDigits[digit]++;
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            int[] temp = new int[10];
            int num = i;
            while (num > 0) {
                temp[num % 10]++;
                num /= 10;
            }

            if (check(countDigits, temp)) resultList.add(i);
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    private boolean check(int[] countDigits, int[] temp) {
        for (int i = 0; i < 10; i++) {
            if (countDigits[i] < temp[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {4, 7, 4, 0, 3, 3, 6, 5, 0, 5, 7, 8, 0, 2, 9, 2, 3, 1, 8};
        System.out.println(Arrays.toString(new LC2094_findEvenNumbers().findEvenNumbers(array)));
    }
}
