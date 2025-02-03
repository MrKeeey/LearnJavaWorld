package PracticeTasks;

public class LC3105_longestMonotonicSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;

        for (int i = 1; i < n; i++) {

            while (i < n && nums[i] < nums[i - 1]) {
                decLength++;
                i++;
            }
            while (i < n && nums[i] > nums[i - 1]) {
                incLength++;
                i++;
            }
            while (i < n && nums[i] == nums[i - 1]) {
                i++;
            }

            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
            incLength = 1;
            decLength = 1;
            i--;
        }

        return maxLength;
    }

    public int longestMonotonicSubarray2(int[] nums) {
        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                incLength++;
                decLength = 1;
            } else if (nums[i] > nums[i + 1]) {
                incLength = 1;
                decLength++;
            } else {
                incLength = 1;
                decLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 3, 3, 2};
        System.out.println(new LC3105_longestMonotonicSubarray().longestMonotonicSubarray(array));
        System.out.println(new LC3105_longestMonotonicSubarray().longestMonotonicSubarray2(array));
    }

}
