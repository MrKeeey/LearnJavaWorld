package PracticeTasks;

public class LC1014_maxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int iPair = values[0];

        for (int x = 1; x < values.length; x++) {
            int jPair = values[x] - x;
            result = Math.max(result, iPair + jPair);
            int currentIPair = values[x] + x;
            iPair = Math.max(iPair, currentIPair);
        }

        return result;
    }

    //faster or no
    public int maxScoreSightseeingPair2(int[] values) {
        int maxValue = 0;
        int current = 0;

        for (int value : values) {
            maxValue = Math.max(maxValue, current + value);
            current = Math.max(current, value) - 1;
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] array = {8, 1, 5, 2, 6};
        System.out.println(new LC1014_maxScoreSightseeingPair().maxScoreSightseeingPair2(array));
    }
}
