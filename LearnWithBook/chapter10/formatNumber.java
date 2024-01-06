package LearnWithBook.chapter10;

public class formatNumber {
    public static void main(String[] args) {
        String str = String.format("%,d", 123456789);
        System.out.println(str);

        str = String.format("I want to change %,.2f errors", 1233444.4987);
        System.out.println(str);
    }
}
