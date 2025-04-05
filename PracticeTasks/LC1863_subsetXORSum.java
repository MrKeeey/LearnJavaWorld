package PracticeTasks;

public class LC1863_subsetXORSum {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result |= num;
        }
        return result << nums.length - 1;
    }

    public int subsetXORSum2(int[] nums) {
        return XORAll(nums, 0, 0);
    }

    private int XORAll(int[] nums, int index, int currentXOR) {
        if (index == nums.length) return currentXOR;
        int withElement = XORAll(nums, index + 1, currentXOR ^ nums[index]);
        int withoutElement = XORAll(nums, index + 1, currentXOR);
        return withElement + withoutElement;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 8};
        System.out.println(new LC1863_subsetXORSum().subsetXORSum(array));
        System.out.println(new LC1863_subsetXORSum().subsetXORSum2(array));
    }
}
