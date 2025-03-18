package PracticeTasks;

public class LC2401_longestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int length = 0;
        int totalBits = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            while ((totalBits & nums[end]) != 0) {
                totalBits ^= nums[start++];
            }
            totalBits |= nums[end];
            length = Math.max(length, end - start + 1);
        }

        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 8, 48, 10};
        System.out.println(new LC2401_longestNiceSubarray().longestNiceSubarray(nums));
    }
}
