package PracticeTasks;

public class LC2560_minCapability {
    public int minCapability(int[] nums, int k) {
        int minMoney = nums[0];
        int maxMoney = nums[0];
        for (int num : nums) {
            minMoney = Math.min(minMoney, num);
            maxMoney = Math.max(maxMoney, num);
        }

        while (minMoney <= maxMoney) {
            int mid = (minMoney + maxMoney) / 2;
            int possible = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    possible++;
                    i++;
                }
            }

            if (possible < k) {
                minMoney = mid + 1;
            } else {
                maxMoney = mid - 1;
            }
        }

        return minMoney;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 9, 3, 1};
        System.out.println(new LC2560_minCapability().minCapability(array, 2));
    }
}
