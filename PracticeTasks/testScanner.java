package PracticeTasks;

import java.util.Scanner;

public class testScanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        System.out.println("Name: " + name + "\nAge: " + age);

        String line = "15 meow 23 Hello 5 w 6.66 d";
        Scanner testScanner = new Scanner(line);

        while (testScanner.hasNext()) {
            if (testScanner.hasNextInt()) {
                int test = testScanner.nextInt();
                System.out.println(test);
            } else {
                testScanner.next();
            }
        }

        scanner.close();
        testScanner.close();
    }
}
