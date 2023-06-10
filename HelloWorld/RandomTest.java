import java.util.Random;
public class RandomTest {
    public static void main(String[] args) {
        //Test how work random
        Random random = new Random();
        int randomizer = 0, counter = 0;

        while (randomizer != 5){
            randomizer = random.nextInt(10);
            System.out.print(randomizer);
            if (randomizer == 0) counter++;
        }
        System.out.println();
        System.out.println("Found zero " + counter + " times");

        //Random elements + create array elements without repeats
        char[] InputArray = {'a', 'p', 'm', 'f', 'r'};
        char[] OutputArray = new char[InputArray.length];
        int foundrepeat = 0;

        //Add 1st element
        counter = 0;
        randomizer = random.nextInt(InputArray.length);
        OutputArray[counter] = InputArray[randomizer];
        counter++;

        while (counter != InputArray.length) {
            randomizer = random.nextInt(InputArray.length);             //random
            for (int j = 0; j < counter; j++) {
            if (OutputArray[j] == InputArray[randomizer]) {             //if we search repeat --> random again
                foundrepeat = 0;
                break;
            } else {                                                    //add element in array if 0 repeats
                foundrepeat++;
                if (foundrepeat == counter) {
                    OutputArray[counter] = InputArray[randomizer];
                    counter++;
                    foundrepeat = 0;
                    break;
                    }
                }
            }
        }
        System.out.print(OutputArray);
    }
}