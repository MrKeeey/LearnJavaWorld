import java.util.Random;
public class Food {
    public static void main(String[] args) {
        //Test how work random
        Random rand = new Random();
        int r = 0, i = 0;

        while (r != 5){
            r = rand.nextInt(10);
            System.out.print(r);
            if (r == 0) i++;
        }
        System.out.println();
        System.out.println("Found zero " + i + " times");

        //Random all food + without repeats
        char[] InputArray = {'a', 'p', 'm', 'f', 'r'};
        char[] OutputArray = new char[InputArray.length];
        int k = 0, rnd, counter = 0;

        rnd = rand.nextInt(InputArray.length);
        OutputArray[k] = InputArray[rnd];
        k++;

        while (k != InputArray.length) {
            rnd = rand.nextInt(InputArray.length);
            for (int j = 0; j < k; j++) {
            if (OutputArray[j] == InputArray[rnd]) {
                counter = 0;
                break;
            } else {
                counter++;
                if (counter == k) {
                    OutputArray[k] = InputArray[rnd];
                    k++;
                    counter = 0;
                    break;
                    }
                }
            }
        }
        System.out.print(OutputArray);
    }
}