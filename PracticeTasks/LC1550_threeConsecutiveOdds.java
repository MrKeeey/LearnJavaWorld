package PracticeTasks;

public class LC1550_threeConsecutiveOdds {
    public static void main(String[] args) {
        int[] array = {1, 1, 1};
        System.out.println(threeConsecutiveOdds(array));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i <= arr.length - 3; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            } else if (arr[i + 1] % 2 == 0) {
                i = i + 1;
            } else if (arr[i + 2] % 2 == 0) {
                i = i + 2;
            }
        }
        return false;
    }
}