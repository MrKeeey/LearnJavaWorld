package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC_MaxLengthStringArray {
    public static void main(String[] args) {
        List<String> inputArray= new ArrayList<String>();
        inputArray.add("cha");
        inputArray.add("r");
        inputArray.add("act");
        inputArray.add("ers");
        maxLength(inputArray);
    }

    private static int maxLength (List<String> arr) {
        if (arr.size() == 1) {
            return arr.get(0).length();
        }
        int maxIndex = 0;
        int indexForRemove = 0;
        for (int i = 0; i < 2; i++) {
            int max = arr.get(0).length();
            for (int j = 1; j < arr.size(); j++) {
                if (arr.get(j).length() > max) {
                    max = arr.get(j).length();
                    indexForRemove = j;
                }
            }
            arr.remove(indexForRemove);
            maxIndex += max;
        }
        return maxIndex;
    }
}
