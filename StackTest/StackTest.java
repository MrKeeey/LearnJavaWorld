import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Random;
public class StackTest {
    public static void main(String[] args) {
        char[] InputArray = {'a', 'p', 'm', 'f', 'r'};
        Stack Food = new Stack();
        Random random = new Random();
        int randomnumber;

        for (int i = 0; i<InputArray.length; i++){
            Food.add(InputArray[i]);
        }
        System.out.println(InputArray);
        System.out.println(Food);

        for (int i = 0; i < InputArray.length; i++){
            try {
                randomnumber = random.nextInt(Food.size());
                InputArray[i] = (char) Food.get(randomnumber);
                Food.remove(randomnumber);
            } catch (EmptyStackException e){
                System.out.println("Stack Empty");
            }
        }
        System.out.println(InputArray);
        System.out.println(Food);
    }
}