package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC624_maxDistance {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(-2);
        l.add(1);
        l.add(4);
        l.add(5);
        list.add(l);
        l = new ArrayList<>();
        l.add(-2);
        l.add(5);
        l.add(6);
        list.add(l);
        l = new ArrayList<>();
        l.add(-2);
        l.add(0);
        list.add(l);
        System.out.println(maxDistance(list));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = Integer.MIN_VALUE;
        int first = arrays.get(0).get(0);
        int last = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            int currentFirst = arrays.get(i).get(0);
            int currentLast = arrays.get(i).get(arrays.get(i).size() - 1);
            maxDistance = Math.max(maxDistance, Math.abs(first - currentLast));
            maxDistance = Math.max(maxDistance, Math.abs(last - currentFirst));
            first = Math.min(first, currentFirst);
            last = Math.max(last, currentLast);
        }
        return maxDistance;
    }
}
