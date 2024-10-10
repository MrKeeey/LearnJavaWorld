package PracticeTasks;

public class LC962_maxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    maxWidth = Math.max(maxWidth, j - i);
                }
            }
        }
        return maxWidth;
    }

    public int maxWidthRamp2(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxWidth = 0;
        int[] maxNum = new int[n];

        maxNum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxNum[i] = Math.max(maxNum[i + 1], nums[i]);
        }

        while (right < n) {
            while (left < right && nums[left] > maxNum[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        System.out.println(new LC962_maxWidthRamp().maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(new LC962_maxWidthRamp().maxWidthRamp2(new int[]{6, 0, 8, 2, 1, 5}));
    }
}
