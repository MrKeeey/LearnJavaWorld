package PracticeTasks;

public class LC2918_minSum {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1Sum = 0;
        long nums2Sum = 0;
        int nums1CountZeroes = 0;
        int nums2CountZeroes = 0;

        for (int num : nums1) {
            nums1Sum += num;
            if (num == 0) nums1CountZeroes++;
        }

        for (int num : nums2) {
            nums2Sum += num;
            if (num == 0) nums2CountZeroes++;
        }

        long nums1MinSum = nums1Sum + nums1CountZeroes;
        long nums2MinSum = nums2Sum + nums2CountZeroes;

        if (nums1CountZeroes == 0 && nums2MinSum > nums1Sum) return -1;
        if (nums2CountZeroes == 0 && nums1MinSum > nums2Sum) return -1;

        return Math.max(nums1MinSum, nums2MinSum);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 0, 1, 0};
        int[] nums2 = {6, 5, 0};
        System.out.println(new LC2918_minSum().minSum(nums1, nums2));
    }
}
