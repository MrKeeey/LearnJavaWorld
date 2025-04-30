package PracticeTasks;

public class LC1295_findNumbers {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
//            if (String.valueOf(num).length() % 2 == 0) count++;
//            if (num >= 10 && num < 100 || num >= 1000 && num < 10000 || num == 100000) count++;
//            if ((int)(Math.log10(num) + 1) % 2 == 0) count++;
            int length = 0;
            while (num != 0) {
                num /= 10;
                length++;
            }
            if (length % 2 == 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(new LC1295_findNumbers().findNumbers(nums));
    }
}
