package PracticeTasks;

public class LC2206_divideArray {
    public boolean divideArray(int[] nums) {
        int[] countNum = new int[501];

        for (int num : nums) {
            countNum[num]++;
        }

        for (int count : countNum) {
            if (count % 2 == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 2};
        System.out.println(new LC2206_divideArray().divideArray(nums));
    }
}
