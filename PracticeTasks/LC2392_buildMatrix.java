package PracticeTasks;

import java.util.*;

public class LC2392_buildMatrix {
    public static void main(String[] args) {
        LC2392_buildMatrix bm = new LC2392_buildMatrix();
        int[][] rowRules = {{1, 2}, {7, 3}, {4, 3}, {5, 8}, {7, 8}, {8, 2}, {5, 8}, {3, 2}, {1, 3}, {7, 6}, {4, 3}, {7, 4}, {4, 8}, {7, 3}, {7, 5}};
        int[][] colRules = {{5, 7}, {2, 7}, {4, 3}, {6, 7}, {4, 3}, {2, 3}, {6, 2}};
        System.out.println(Arrays.deepToString(bm.buildMatrix(8, rowRules, colRules)));
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] result = new int[k][k];

        List<Integer> rowList = makeOrder(rowConditions);
        List<Integer> colList = makeOrder(colConditions);

        if (rowList.isEmpty() || colList.isEmpty()) {
            return new int[0][];
        }

        Set<Integer> rowSet = new HashSet<>(rowList);
        Set<Integer> colSet = new HashSet<>(colList);

        for (int i = 1; i <= k; i++) {
            if (!rowSet.contains(i)) {
                rowList.add(i);
            }
            if (!colSet.contains(i)) {
                colList.add(i);
            }
        }

        int n = rowList.size();
        int m = colList.size();
        if (n > k || m > k) {
            return new int[0][];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int buff = rowList.get(i);
                if (buff == colList.get(j)) {
                    result[i][j] = buff;
                }
            }
        }

        return result;
    }


    private static List<Integer> makeOrder(int[][] conditions) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> countIn = new HashMap<>();

        for (int[] condition : conditions) {
            int above = condition[0];
            int below = condition[1];

            graph.computeIfAbsent(above, x -> new ArrayList<>()).add(below);
            graph.putIfAbsent(below, new ArrayList<>());
            countIn.put(below, countIn.getOrDefault(below, 0) + 1);
            countIn.putIfAbsent(above, 0);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (var pair : countIn.entrySet()) {
            if (pair.getValue() == 0) {
                queue.add(pair.getKey());
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (var neighbor : graph.get(node)) {
                countIn.put(neighbor, countIn.get(neighbor) - 1);
                if (countIn.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (order.size() != countIn.size()) {
            return new ArrayList<>();
        }

        return order;
    }
}
