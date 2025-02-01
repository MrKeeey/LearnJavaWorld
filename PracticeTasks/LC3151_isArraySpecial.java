package PracticeTasks;

public class LC3151_isArraySpecial {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] % 2 == nums[i + 1] % 2) {
            if (((nums[i] % 2) ^ (nums[i + 1] % 2)) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 1, 6};
        System.out.println(new LC3151_isArraySpecial().isArraySpecial(array));
    }
}