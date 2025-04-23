package PracticeTasks;

public class LC1399_countLargestGroup {
    public int countLargestGroup(int n) {
        int[] digitsSum = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            ++digitsSum[sum];
        }

        int count = 0;
        int maxSize = 0;
        for (int sum : digitsSum) {
            if (sum > maxSize) {
                maxSize = sum;
                count = 1;
            } else if (sum == maxSize) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LC1399_countLargestGroup().countLargestGroup(13));
    }
}
