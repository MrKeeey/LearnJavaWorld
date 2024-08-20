package HelloWorld;

import java.util.Scanner;

public class testForAndForEach {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        char[] arraySymbols = new char[]{'H', 'e', 'l', 'l', 'o'};
        for (char c: arraySymbols) {
            System.out.print(c + " ");
        }
        System.out.println();

        Scanner console = new Scanner(System.in);
        String s = "";
        for (;;) {
            s = console.nextLine();
            System.out.println(s);
            if (s.equals("exit"))
                break;
        }
        System.out.println("First loop ended!");

        for (;true;) {
            s = console.nextLine();
            System.out.println(s);
            if (s.equals("exit"))
                break;
        }
        System.out.println("Second loop ended!");
    }
}
