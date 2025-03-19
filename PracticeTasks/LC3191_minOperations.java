package PracticeTasks;

public class LC3191_minOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                count++;
            }
        }

        return (nums[n - 1] & nums[n - 2]) == 0 ? -1 : count;
    }

    public static void main(String[] args) {
        int[] bits = {0, 1, 1, 1};
        System.out.println(new LC3191_minOperations().minOperations(bits));
    }
}
