package PracticeTasks;

public class LC2425_xorAllNums {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        int m = nums1.length;
        int n = nums2.length;

        if (m % 2 == 1) {
            for (int num : nums2) {
                result ^= num;
            }
        }

        if (n % 2 == 1) {
            for (int num : nums1) {
                result ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 3};
        int[] nums2 = {10, 2, 5, 0};
        System.out.println(new LC2425_xorAllNums().xorAllNums(nums1, nums2));
    }
}
