package PracticeTasks;

public class LC3392_countSubarrays {
    public int countSubarrays(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = {-1, -4, -1, 4};
        System.out.println(new LC3392_countSubarrays().countSubarrays(array));
    }
}
