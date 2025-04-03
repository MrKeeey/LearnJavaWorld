package PracticeTasks;

public class LC2874_maximumTripletValue {
    public long maximumTripletValue(int[] nums) {
        long maxElement = 0L;
        long maxIJDiff = 0L;
        long maxTriplet = 0L;

        for (int k : nums) {
            maxTriplet = Math.max(maxTriplet, maxIJDiff * k);
            maxIJDiff = Math.max(maxIJDiff, maxElement - k);
            maxElement = Math.max(maxElement, k);
        }

        return maxTriplet;
    }

    public static void main(String[] args) {
        int[] array = {12, 6, 1, 2, 7};
        System.out.println(new LC2874_maximumTripletValue().maximumTripletValue(array));
    }
}
