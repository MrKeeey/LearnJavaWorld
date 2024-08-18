package HelloWorld;

public class sumFirst100Square {
    public static void main(String[] args) {
        System.out.println(sumSquare(100));
    }

    public static int sumSquare(int n) {
        int result = 0;

        for (int i = 0; i <= n; i++) {
            //result += i * i;
            result += (int) Math.pow(i, 2);
        }

        return result;
    }
}