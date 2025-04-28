package PracticeTasks;

public class LC2302_countSubarrays {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 3, 5};
        System.out.println(new LC2302_countSubarrays().countSubarrays(array, 10));
    }
}
