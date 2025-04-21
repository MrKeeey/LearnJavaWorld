package PracticeTasks;

public class LC2145_numberOfArrays {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0;
        int max = 0;
        int sum = 0;
        for (int difference : differences) {
            sum += difference;
            min = Math.min(min, sum);
            max = Math.max(max, sum);

            if (upper - lower < max - min) return 0;
        }

        return (upper - lower) - (max - min) + 1;
    }

    public static void main(String[] args) {
        int[] array = {1, -3, 4};
        System.out.println(new LC2145_numberOfArrays().numberOfArrays(array, 1, 6));
    }
}
