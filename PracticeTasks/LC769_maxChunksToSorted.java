package PracticeTasks;

public class LC769_maxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int sumArr = 0;
        int sumSortedArr = 0;

        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
            sumSortedArr += i;
            if (sumArr == sumSortedArr) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 2, 3, 4};
        System.out.println(new LC769_maxChunksToSorted().maxChunksToSorted(array));
    }
}
