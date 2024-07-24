package PracticeTasks;

import java.util.*;

public class LC2191_sortJumbled {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums = {9, 99, 999, 9999, 999999999};
        System.out.println(Arrays.toString(sortJumbled(array, nums)));
        //System.out.println(Arrays.toString(sortJumbled2(array, nums)));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int num : nums) {
            int newNum = 0;
            if (num == 0) {
                newNum = mapping[0];
            } else {
                int buffNum = num;
                int tens = 1;
                while (buffNum > 0) {
                    newNum += mapping[buffNum % 10] * tens;
                    buffNum /= 10;
                    tens *= 10;
                }
            }
            map.computeIfAbsent(newNum, x -> new ArrayList<>()).add(num);
        }

        int count = 0;
        for (List<Integer> listValues : map.values()) {
            for (int val : listValues) {
                nums[count++] = val;
            }
        }

        return nums;
    }

    //slower variant
    public static int[] sortJumbled2(int[] mapping, int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        for (int num : nums) {
            int newNum = 0;
            if (num == 0) {
                newNum = mapping[0];
            } else {
                int buffNum = num;
                int tens = 1;
                while (buffNum > 0) {
                    newNum += mapping[buffNum % 10] * tens;
                    buffNum /= 10;
                    tens *= 10;
                }
            }
            List<Integer> buff = new ArrayList<>();
            buff.add(newNum);
            buff.add(num);
            list.add(buff);
        }

        list.sort(((o1, o2) -> o1.get(0).equals(o2.get(0)) ? o1.get(1) : o1.get(0) - o2.get(0)));

        int count = 0;
        for (List<Integer> listValues : list) {
            nums[count++] = listValues.get(1);
        }

        return nums;
    }
}
