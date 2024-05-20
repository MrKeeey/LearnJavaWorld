package PracticeTasks;

public class LC_SubsetXORSum {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 8};
        System.out.println(subsetXORSum(array));
    }

    public static int subsetXORSum(int[] nums) {
        return sumXOR(nums, 0, 0);
    }

    public static int sumXOR(int[] nums, int index, int currentXOR) {
        if (index == nums.length) return currentXOR;

        int withElement = sumXOR(nums, index + 1, nums[index] ^ currentXOR);
        int withoutElement = sumXOR(nums, index + 1, currentXOR);

        return withElement + withoutElement;
    }
}
