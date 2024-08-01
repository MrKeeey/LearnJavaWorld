package PracticeTasks;

public class LC713_numSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(array, 100));
        System.out.println(numSubarrayProductLessThanK2(array, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length) {
                product *= nums[j];
                if (product < k) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
            product = 1;
        }
        return count;
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        int product = 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k && j <= i) {
                product /= nums[j];
                j++;
            }
            count += i - j + 1;
        }
        return count;
    }
}
