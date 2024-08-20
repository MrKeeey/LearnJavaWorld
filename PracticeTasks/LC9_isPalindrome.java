package PracticeTasks;

public class LC9_isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int r;
        int sum = 0;
        int temp = x;
        while (x > 0) {
            r = x % 10;
            sum = (sum * 10) + r;
            x /= 10;
        }
        return temp == sum;
    }
}
