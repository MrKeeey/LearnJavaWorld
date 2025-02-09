package PracticeTasks;

import java.util.HashMap;
import java.util.TreeSet;

public class LC2349_numberContainers {
    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
    }
}

class NumberContainers {

    private HashMap<Integer, Integer> indexAndNumber;
    private HashMap<Integer, TreeSet<Integer>> numberAndIndexes;

    public NumberContainers() {
        numberAndIndexes = new HashMap<>();
        indexAndNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexAndNumber.containsKey(index)) {
            int prevNum = indexAndNumber.get(index);
            numberAndIndexes.get(prevNum).remove(index);

            if (numberAndIndexes.get(prevNum).isEmpty()) {
                numberAndIndexes.remove(prevNum);
            }
        }

        indexAndNumber.put(index, number);
        numberAndIndexes.putIfAbsent(number, new TreeSet<>());
        numberAndIndexes.get(number).add(index);
        //numberAndIndexes.computeIfAbsent(number, x-> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (numberAndIndexes.containsKey(number)) {
            return numberAndIndexes.get(number).first();
        }
        return -1;
    }
}
