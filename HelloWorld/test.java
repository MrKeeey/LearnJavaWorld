package HelloWorld;

import java.util.Random;

public class test {
    public static void main(String[] args) {

        //1.(Заданая Одномерка)
        int[] z = new int[8];
        int value = 17;
        for (int i = 0; i < z.length; i++) {
            z[i] = value;
            value -= 2;
        }

        //2.(Рандом Одномерка)
        double[] x = new double[10];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = -9.0 + (15.0 * random.nextDouble());
        }

        //3.(Двумер0чка)
        double[][] AyE = new double[8][10];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (z[i] == 11) {
                    AyE[i][j] = Math.asin(0.25 * Math.pow((x[j] - 1.5) / 15, 2));
                } else if (AyE[i][j] == 3 || AyE[i][j] == 5 || AyE[i][j] == 15 || AyE[i][j] == 17) {
                    AyE[i][j] = Math.exp(Math.cos(Math.sin(x[j])));
                } else {
                    AyE[i][j] = Math.pow((1.0 / 3.0) / (0.75 + Math.tan(Math.asin(0.75 * ((x[j] - 1.5) / 15)))), 3);
                }
            }
        }

        System.out.println("Array z:" );
        for (double[] row : AyE) {
            for (double elem : row) {
                System.out.printf("%.5f ", elem);
            }
            System.out.println();
        }
    }
}
