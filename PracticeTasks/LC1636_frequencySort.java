package PracticeTasks;

import java.util.*;

public class LC1636_frequencySort {
    public static void main(String[] args) {
        int[] array = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println(Arrays.toString(frequencySort(array)));
        System.out.println(Arrays.toString(frequencySort2(array)));
    }

    public static int[] frequencySort(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Integer> numsCount = new HashMap<>();
        for (int num : nums) {
            numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> listPairs = new ArrayList<>(numsCount.entrySet());
        listPairs.sort(((o1, o2) -> o1.getValue().equals(o2.getValue()) ?
                o2.getKey() - o1.getKey() : o1.getValue() - o2.getValue()));
/*        listPairs.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o2.getKey() - o1.getKey();
                } else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });*/

        int count = 0;
        for (Map.Entry<Integer, Integer> pair : listPairs) {
            int n = pair.getValue();
            for (int i = 0; i < n; i++) {
                result[count++] = pair.getKey();
            }
        }

        return result;
    }

/*    2-ой способ добавление в Map, потом в TreeMap + достать список значение и отсортировать их
     + доставать значение с обратного конца.*/
    public static int[] frequencySort2(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Integer> numsCount = new HashMap<>();
        for (int num : nums) {
            numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> sortedNumsCount = new TreeMap<>();
        for (var pair : numsCount.entrySet()) {
            sortedNumsCount.computeIfAbsent(pair.getValue(), x -> new ArrayList<>()).add(pair.getKey());
        }

        int count = 0;
        for (var pair : sortedNumsCount.entrySet()) {
            List<Integer> numsList = pair.getValue();
            if (numsList.size() > 1) {
                numsList.sort(((o1, o2) -> o1 - o2));
            }
            for (int i = numsList.size() - 1; i >= 0; i--) {
                for (int j = 0; j < pair.getKey(); j++) {
                    result[count++] = numsList.get(i);
                }
            }
        }

        return result;
    }
}
