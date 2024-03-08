package PracticeTasks;

import javax.sound.midi.Soundbank;
import java.net.Socket;

public class SumNumbers {
    public static final int MAX_LIMIT = 1000;

    public static void main(String[] args) {

        for (int i = 0; i < MAX_LIMIT; i++) {

            if (i % 3 == 0 && i % 5 != 0) {
                if (i < 10) {
                    System.out.print(i + " ");
                } else {
                    //new SumNumbers().sum(i);

                    int buff = i;
                    int sum = 0;

                    while (buff != 0) {
                        sum += (buff % 10);
                        buff /= 10;
                    }

                    if (sum < 10) {
                        System.out.print(i + " ");
                    }
                }
            }
        }

    }

    private void sum(int number) {

        String buffer = "" + number;
        int result = 0;

        for (int i = 0; i < buffer.length(); i++) {
            result += Integer.parseInt(String.valueOf(buffer.charAt(i)));
        }

        if (result < 10) {
            System.out.print(number + " ");
        }

    }
}
