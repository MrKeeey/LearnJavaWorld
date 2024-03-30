package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_ThreeSum {
    public static void main(String[] args) {
        int[] num = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(threeSum(num));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                }
                if (sum < 0) {
                    j++;
                }
                if (sum > 0) {
                    k--;
                }
            }
            i++;
        }
        return result;
    }
}
