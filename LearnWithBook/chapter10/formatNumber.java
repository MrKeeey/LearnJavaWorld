package LearnWithBook.chapter10;

public class formatNumber {
    public static void main(String[] args) {
        String str = String.format("%,d", 123456789);
        System.out.println(str);

        str = String.format("I want to change %,.2f errors", 1233444.4987);
        System.out.println(str);

        System.out.println(String.format("%d", 42));
        System.out.println(String.format("%.3f", 42.000000));
        System.out.println(String.format("%x", 42));
        System.out.println(String.format("%c", 42));

        System.out.println(String.format("I have %d marks form %d marks", 88, 100));
    }
}
