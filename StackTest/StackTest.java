import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        String[] InputArray = {"Eggs", "Rice", "Fish", "Meat", "Water"};
        Stack SortStack = new Stack();
        Random random = new Random();

        //Add elements in Stack
        Collections.addAll(SortStack, InputArray);
        System.out.println(Arrays.toString(InputArray));
        System.out.println(SortStack);

        //Random element from Stack + rewrite array + clear Stack
        //try catch can be deleted
        for (int i = 0; i < InputArray.length; i++){
            try {
                int randomizer = random.nextInt(SortStack.size());
                InputArray[i] = (String) SortStack.get(randomizer);
                SortStack.remove(randomizer);
            } catch (EmptyStackException e){
                System.out.println("Stack Empty");
            }
        }
        System.out.println(Arrays.toString(InputArray));
        System.out.println(SortStack);
    }
}