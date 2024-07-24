package PracticeTasks;

public class LC35_searchInsert {
    public static void main(String[] args) {
        int[] sortArray = {1, 3, 5, 7};
        System.out.println(searchInsert(sortArray, 8));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[left]) return 0;
        if (target > nums[right]) return right + 1;

        while (left <= right) {
            if (target == nums[left]) return left;
            if (target == nums[right]) return right;

            int mid = (right + left) / 2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
}