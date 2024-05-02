package PracticeTasks;

public class LC_FindMaxKInArray {
    public static void main(String[] args) {
        int[] array = {-1, 10, 6, 7, -7, 1};
        System.out.println(findMaxK(array));
    }

    public static int findMaxK(int[] nums) {
        boolean[] countOfPlusNum = new boolean[1001];
        boolean[] countOfMinusNum = new boolean[1001];
        for (int elem : nums) {
            if (elem > 0) {
                countOfPlusNum[elem] = true;
            } else {
                countOfMinusNum[-elem] = true;
            }
        }
        for (int i = countOfPlusNum.length - 1; i >= 0; i--) {
            if (countOfPlusNum[i] && countOfMinusNum[i]) {
                return i;
            }
        }
        return -1;
    }
}
