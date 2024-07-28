package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_fourSum {
    public static void main(String[] args) {
        //int[] array = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] array = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(array, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length - 1;
        Arrays.sort(nums);

        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                for (int k = j + 1; k <= n - 1; k++) {
                    int end = n;
                    while (k < end) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[end];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[end]));
                            while (k < end && nums[k] == nums[k + 1]) {
                                k++;
                            }
                            while (j < k && nums[j] == nums[j + 1]) {
                                j++;
                            }
                            while (i < j && nums[i] == nums[i + 1]) {
                                i++;
                            }
                            k++;
                            end--;
                        }
                        if (sum > target) {
                            end--;
                        }
                        if (sum < target) {
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }

}
