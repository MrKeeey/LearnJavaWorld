package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_combinationSum2 {
    public static void main(String[] args) {
        int[] array = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(array, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        if (target > 0) {
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                helper(result, list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
