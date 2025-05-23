package PracticeTasks;

public class LC2176_countPairs {
    public int countPairs(int[] nums, int k) {
        int countPairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    countPairs++;
                }
            }
        }

        return countPairs;
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 2, 2, 1, 3};
        System.out.println(new LC2176_countPairs().countPairs(array, 2));
    }
}
