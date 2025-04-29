package PracticeTasks;

public class LC2962_countSubarrays {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) maxNum = num;
        }

        int n = nums.length;
        int countMax = 0;
        long result = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if (nums[right] == maxNum) countMax++;

            while (left <= right && countMax == k) {
                result += n - right;
                if (nums[left] == maxNum) countMax--;
                left++;
            }
        }

        return result;
    }

    // with reslut += left; and countMax check before
    public long countSubarrays2(int[] nums, int k) {
        int maxNum = 0;
        int count = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
                count = 0;
            }
            if (num == maxNum) count++;
        }

        if (count < k) return 0;

        count = 0;
        long result = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == maxNum) count++;

            while (left <= right && count >= k) {
                if (nums[left] == maxNum) count--;
                left++;
            }

            result += left;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 3};
        System.out.println(new LC2962_countSubarrays().countSubarrays(array, 2));
        System.out.println(new LC2962_countSubarrays().countSubarrays2(array, 2));
    }
}
