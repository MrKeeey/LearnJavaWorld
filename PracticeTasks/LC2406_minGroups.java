package PracticeTasks;

public class LC2406_minGroups {
    public int minGroups(int[][] intervals) {
        int[] countIntervals = new int[1000002];

        for (int[] interval : intervals) {
            countIntervals[interval[0]]++;
            countIntervals[interval[1] + 1]--;
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;
        for (int count : countIntervals) {
            concurrentIntervals += count;
            maxConcurrentIntervals = Math.max(maxConcurrentIntervals, concurrentIntervals);
        }

        return maxConcurrentIntervals;
    }

    public static void main(String[] args) {
        int[][] array = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(new LC2406_minGroups().minGroups(array));
    }
}
