package PracticeTasks;

public class LC3396_minimumOperations {
    public int minimumOperations(int[] nums) {
        boolean[] duplicates = new boolean[101];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (duplicates[nums[i]]) {
                return i / 3 + 1;
            }
            duplicates[nums[i]] = true;
        }

        return 0;
    }

    //my try
    public int minimumOperations2(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }

        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i += 3) {
            if (!hasDuplicates(count)) break;

            result++;
            count[nums[i]]--;
            if (i + 1 < n) count[nums[i + 1]]--;
            if (i + 2 < n) count[nums[i + 2]]--;
        }

        return result;
    }

    private boolean hasDuplicates(int[] count) {
        for (int c : count) {
            if (c > 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 4, 4};
        System.out.println(new LC3396_minimumOperations().minimumOperations(array));
        System.out.println(new LC3396_minimumOperations().minimumOperations2(array));
    }
}
