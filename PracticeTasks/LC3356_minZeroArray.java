package PracticeTasks;

public class LC3356_minZeroArray {
    public int minZeroArray(int[] nums, int[][] queries) {
        int k = 0;
        int n = nums.length;
        int sum = 0;
        int[] temp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            while (sum + temp[i] < nums[i]) {
                k++;
                if (k > queries.length) return -1;

                int left = queries[k - 1][0];
                int right = queries[k - 1][1];
                int val = queries[k - 1][2];

                if (right >= i) {
                    temp[Math.max(left, i)] += val;
                    temp[right + 1] -= val;
                }
            }
            sum += temp[i];
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[][] q = {{1, 3, 2}, {0, 2, 1}};
        System.out.println(new LC3356_minZeroArray().minZeroArray(nums, q));
    }
}
