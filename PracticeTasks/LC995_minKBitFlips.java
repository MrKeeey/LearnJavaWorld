package PracticeTasks;

public class LC995_minKBitFlips {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(minKBitFlips(array, 3));
    }

    public static int minKBitFlips(int[] nums, int k) {
        int flipCount = 0;
        int flipped = 0;
        int n = nums.length;
        int[] isFlipped = new int[n];

        for (int i = 0; i < n; i++) {

            if (i >= k) {
                flipped ^= isFlipped[i - k];
            }

            if (flipped == nums[i]) {
                if (i + k > n) return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                flipCount++;
            }
        }

        return flipCount;
    }
}
