package PracticeTasks;

import java.util.Arrays;

public class LC287_findDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate2(nums));
        System.out.println(findDuplicate3(nums));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1, k = n; j <= k; j++, k--) {
                if (nums[i] == nums[j] || nums[i] == nums[k]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static int findDuplicate2(int[] nums) {
        boolean[] result = new boolean[nums.length];
        for (int num : nums) {
            if (result[num]) {
                return num;
            }
            result[num] = true;
        }
        return 0;
    }

    public static int findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
