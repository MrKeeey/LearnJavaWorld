package PracticeTasks;

public class LC2594_repairCars {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) ranks[0] * cars * cars;
        while (left < right) {
            int totalCars = 0;
            long mid = (left + right) / 2;
            for (int rank : ranks) {
                totalCars += (int) Math.sqrt(1.0 * mid / rank);
            }

            if (totalCars < cars) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 3, 1};
        System.out.println(new LC2594_repairCars().repairCars(array, 10));
    }
}
