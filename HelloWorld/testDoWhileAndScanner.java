package HelloWorld;

import java.util.Scanner;

public class testDoWhileAndScanner {
    public static void main(String[] args) {
        String s = "";
        Scanner console = new Scanner(System.in);

        do {
            s = console.nextLine();
            System.out.println(s);
        } while (!s.equals("exit"));
    }
}
