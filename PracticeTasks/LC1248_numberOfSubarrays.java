package PracticeTasks;

public class LC1248_numberOfSubarrays {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays(array, 2));
        System.out.println(numberOfSubarrays2(array, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return countSubArrays(nums, k) - countSubArrays(nums, k - 1);
    }

    private static int countSubArrays(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int windowsSize = 0;

        for (int end = 0; end < nums.length; end++) {
            windowsSize += nums[end] % 2;

            while (windowsSize > k) {
                windowsSize -= nums[start] % 2;
                start++;
            }

            count += end - start + 1;
        }

        return count;
    }

    public static int numberOfSubarrays2(int[] nums, int k) {
        int countSubArrays = 0;
        int countOdd = 0;
        int start = 0;
        int initialGap = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                countOdd++;
            }
            if (countOdd == k) {
                initialGap = 0;
                while (countOdd == k) {
                    countOdd -= nums[start] % 2;
                    start++;
                    initialGap++;
                }
            }
            countSubArrays += initialGap;
        }

        return countSubArrays;
    }
}
