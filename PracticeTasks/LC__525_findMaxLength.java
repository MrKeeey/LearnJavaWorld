package PracticeTasks;

public class LC__525_findMaxLength {
    public static void main(String[] args) {
        int[] array = {0, 1};
        System.out.println(findMaxLength(array));
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int countZero = 0;
            int countOne = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
                if (countZero == countOne) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
