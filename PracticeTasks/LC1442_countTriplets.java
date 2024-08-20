package PracticeTasks;

public class LC1442_countTriplets {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 6, 7};
        System.out.println(countTriplets(array));
    }

    public static int countTriplets(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int a = 0;
            for (int j = i + 1; j < n; j++) {
                a ^= arr[j - 1];
                int b = 0;
                for (int k = j; k < n; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
