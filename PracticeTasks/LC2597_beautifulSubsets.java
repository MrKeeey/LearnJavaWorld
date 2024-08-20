package PracticeTasks;

import java.util.ArrayList;
import java.util.Arrays;

public class LC2597_beautifulSubsets {
    public static void main(String[] args) {
        int[] array = {2, 4, 6};
        System.out.println(beautifulSubsets(array, 2));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> totalSubsets = new ArrayList<>();
        totalSubsets.add(new ArrayList<>());

        for (int num : nums) {
            ArrayList<ArrayList<Integer>> buffer = new ArrayList<>();
            for (ArrayList<Integer> element : totalSubsets) {
                if (!element.contains(num - k)) {
                    buffer.add(
                            new ArrayList<>(element) {{
                                add(num);
                            }}
                    );
                }
            }
            totalSubsets.addAll(buffer);
        }

        return totalSubsets.size() - 1;
    }
}
