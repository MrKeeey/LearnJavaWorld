package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC442_findDuplicates {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] isTaken = new boolean[nums.length + 1];
        for (int num : nums) {
            if (isTaken[num]) {
                result.add(num);
            }
            isTaken[num] = true;
        }
        return result;
    }
}
