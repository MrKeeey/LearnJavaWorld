package PracticeTasks;

public class LC_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long buff = 0;
        while (x != 0) {
            buff *= 10;
            buff += x % 10;
            x /= 10;
            if (buff > Integer.MAX_VALUE || buff < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) buff;
    }
}
