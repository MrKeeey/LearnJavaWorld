package HeadFirst.AppendixB;

public class BitManipulation {
    public static void main(String[] args) {
        int x = 4, y = 5;

        int z = x & y;
        System.out.println(z);
        z = x | y;
        System.out.println(z);
        z = x ^ y;
        System.out.println(z);
        z = ~x;
        System.out.println(z);
        x = x << 2;
        System.out.println(x);
        x = x >> 2;
        System.out.println(x);
        x = x >>> 2;
        System.out.println(x);
    }
}
