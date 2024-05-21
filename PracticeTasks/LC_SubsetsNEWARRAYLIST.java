package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC_SubsetsNEWARRAYLIST {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(subsets(array));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> totalSubsets = new ArrayList<>();
        totalSubsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubset = new ArrayList<>();
            for (List<Integer> currentElem : totalSubsets) {
                newSubset.add(
                        new ArrayList<Integer>(currentElem) {{
                            add(num);
                        }}
                );
            }
            totalSubsets.addAll(newSubset);
        }
        return totalSubsets;
    }
}