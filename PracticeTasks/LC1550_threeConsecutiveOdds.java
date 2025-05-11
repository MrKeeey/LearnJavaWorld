package PracticeTasks;

public class LC1550_threeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(new LC1550_threeConsecutiveOdds().threeConsecutiveOdds(array));
    }
}
