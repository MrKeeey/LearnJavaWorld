package HelloWorld;

public class testPalindrome {

    private static boolean palindrome(int num) {
        String str = String.valueOf(num);
        int last = str.length() - 1;
        for (int i = 0; i < last; i++, last--) {
            if (str.charAt(i) != str.charAt(last)) {
                System.out.println("This isn't palindrome");
                return false;
            }
        }
        System.out.println("It's a palindrome!");
        return true;
    }

    private static boolean palindromeMath(int x) {
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

    public static void main(String[] args) {
        System.out.println(palindrome(-121));
        System.out.println(palindromeMath(121));
    }

}
