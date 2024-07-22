package PracticeTasks;

import java.util.Arrays;
import java.util.TreeMap;

public class LC2418_sortPeople {
    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
        System.out.println(Arrays.toString(sortPeople2(names, heights)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        String[] result = new String[n];

        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        int count = n - 1;
        for (String name : map.values()) {
            result[count--] = name;
        }

        return result;
    }

    public static String[] sortPeople2(String[] names, int[] heights) {
        int n = heights.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            int index = -1;
            for (int j = i; j < n; j++) {
                if (max < heights[j]) {
                    max = heights[j];
                    index = j;
                }
            }
            result[i] = names[index];

            if (index != i) {
                int temp = heights[index];
                heights[index] = heights[i];
                heights[i] = temp;

                String tmp = names[index];
                names[index] = names[i];
                names[i] = tmp;
            }

        }

        return result;
    }
}
