import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Random;
public class StackTest {
    public static void main(String[] args) {
        char[] InputArray = {'a', 'p', 'm', 'f', 'r'};
        Stack Food = new Stack();
        Random random = new Random();

        //Add elements in Stack
        for (char element : InputArray) Food.add(element);
        System.out.println(InputArray);
        System.out.println(Food);

        //Random element from Stack + rewrite array + clear Stack
        //try catch can be deleted
        for (int i = 0; i < InputArray.length; i++){
            try {
                int randomizer = random.nextInt(Food.size());
                InputArray[i] = (char) Food.get(randomizer);
                Food.remove(randomizer);
            } catch (EmptyStackException e){
                System.out.println("Stack Empty");
            }
        }
        System.out.println(InputArray);
        System.out.println(Food);
    }
}