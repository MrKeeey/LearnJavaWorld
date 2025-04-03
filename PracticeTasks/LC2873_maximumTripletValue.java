package PracticeTasks;

public class LC2873_maximumTripletValue {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTriplet = 0L;
        long maxElement = 0L;
        long[] maxIJDiff = new long[n - 1];
        long[] maxK = new long[n];

        for (int i = 0; i < n - 1; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            maxIJDiff[i] = maxElement - nums[i];
        }

        for (int i = n - 1; i >= 2; i--) {
            maxK[i] = Math.max(nums[i],
                    (i < n - 1) ? maxK[i + 1] : 0);
        }

        for (int i = 0; i < n - 1; i++) {
            maxTriplet = Math.max(maxTriplet, maxIJDiff[i] * maxK[i + 1]);
        }

        return maxTriplet;
    }

    //great code
    public long maximumTripletValue2(int[] nums) {
        long maxTriplet = 0;
        long maxElement = 0;
        long maxIJDiff = 0;

        for (int k : nums) {
            maxTriplet = Math.max(maxTriplet, maxIJDiff * k);
            maxIJDiff = Math.max(maxIJDiff, maxElement - k);
            maxElement = Math.max(maxElement, k);
        }

        return maxTriplet;
    }

    public static void main() {
        int[] array = {12, 6, 1, 2, 7};
        System.out.println(new LC2873_maximumTripletValue().maximumTripletValue(array));
        System.out.println(new LC2873_maximumTripletValue().maximumTripletValue2(array));
    }
}
