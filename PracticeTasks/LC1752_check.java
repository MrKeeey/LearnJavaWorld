package PracticeTasks;

public class LC1752_check {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1) return true;

        int inversionCount = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                inversionCount++;
            }
        }

        if (nums[0] < nums[n - 1]) {
            inversionCount++;
        }

        return inversionCount <= 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2, 6, 7};
        System.out.println(new LC1752_check().check(array));
    }

}
