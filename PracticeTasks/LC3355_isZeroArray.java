package PracticeTasks;

public class LC3355_isZeroArray {
    //difference array method from l++ to (r+1)--
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            diff[query[0]]++;
            diff[query[1] + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < nums[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[][] q = {{1, 3}, {0, 2}};
        System.out.println(new LC3355_isZeroArray().isZeroArray(nums, q));
    }
}
