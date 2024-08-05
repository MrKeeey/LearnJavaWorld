package PracticeTasks;

import java.util.HashMap;
import java.util.Map;

public class LC2053_kthDistinct {
    public static void main(String[] args) {
        String[] array = {"d", "b", "c", "b", "c", "a"};
        System.out.println(kthDistinct(array, 2));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
            }
            if (k == 0) {
                return s;
            }
        }

        return "";
    }
}
