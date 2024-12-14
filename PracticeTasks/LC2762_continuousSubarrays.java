package PracticeTasks;

public class LC2762_continuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        long countSubArrays = 0;
        int min = nums[0];
        int max = nums[0];
        int left = 0;
        int right = 0;
        long windowLen;

        for (; right < nums.length; right++) {
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);

            if (max - min > 2) {
                windowLen = right - left;
                countSubArrays += (windowLen * (windowLen + 1)) / 2;
                left = right;
                min = nums[right];
                max = nums[right];

                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    min = Math.min(min, nums[left]);
                    max = Math.max(max, nums[left]);
                }

                if (left < right) {
                    windowLen = right - left;
                    countSubArrays -= (windowLen * (windowLen + 1)) / 2;
                }
            }
        }

        windowLen = right - left;
        countSubArrays += (windowLen * (windowLen + 1)) / 2;

        return countSubArrays;
    }

    public static void main(String[] args) {
        int[] array = {65, 66, 67, 66, 66, 65, 64, 65, 65, 64};
        System.out.println(new LC2762_continuousSubarrays().continuousSubarrays(array));
    }
}
