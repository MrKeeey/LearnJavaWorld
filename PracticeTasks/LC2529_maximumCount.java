package PracticeTasks;

public class LC2529_maximumCount {
    //faster O(log n)
    public int maximumCount(int[] nums) {
        return Math.max(
                lowerBound(nums, 0),
                nums.length - lowerBound(nums, 1)
        );
    }

    private int lowerBound(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    //slower O(n)
    public int maximumCount2(int[] nums) {
        int n = nums.length;
        int neg = 0;
        int index = 0;
        while (index < n && nums[index] < 0) {
            neg++;
            index++;
        }

        while (index < n && nums[index] == 0) {
            index++;
        }

        return Math.max(neg, n - index);
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println(new LC2529_maximumCount().maximumCount(nums));
        System.out.println(new LC2529_maximumCount().maximumCount2(nums));
    }
}
