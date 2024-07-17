package HelloWorld;

import java.util.*;

public class testStack {
    public static void main(String[] args) {
        String[] InputArray = {"Eggs", "Rice", "Fish", "Meat", "Water"};
        Stack<String> SortStack = new Stack<>();
        Random random = new Random();

        //Add elements in Stack
        Collections.addAll(SortStack, InputArray);
        System.out.println(Arrays.toString(InputArray));
        System.out.println(SortStack);

        //Random element from Stack + rewrite array + clear Stack
        for (int i = 0; i < InputArray.length; i++) {
                int randomizer = random.nextInt(SortStack.size());
                //int randomizer = (int) (Math.random() * SortStack.size());
                InputArray[i] = SortStack.get(randomizer);
                SortStack.remove(randomizer);
        }

        System.out.println(Arrays.toString(InputArray));
        System.out.println(SortStack);
    }
}