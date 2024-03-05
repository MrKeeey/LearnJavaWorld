package PracticeTasks;

import java.util.Scanner;

public class WhileAndScanner {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        while (console.hasNextInt()) {
            int number = console.nextInt();
            System.out.println(number);
        }
        System.out.println("First loop ended!");

        String str = "";
        boolean flag = false;
        while (!flag) {
            str = console.nextLine();
            flag = str.equals("exit");
        }
        System.out.println("Second loop ended!");

        while (true){
            str = console.nextLine();
            if (str.equals("exit"))
                break;
        }
        System.out.println("Third loop ended!");
    }
}
