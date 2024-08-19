package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC1431_kidsWithCandies {
    public static void main(String[] args) {
        int[] candies = {4, 2, 1, 1, 2};
        int myCandies = 1;
        System.out.println(kidsWithCandies(candies, myCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int num : candies) {
            if (max < num) {
                max = num;
            }
        }
        for (int i : candies) {
            if (i + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
