package PracticeTasks;

import java.util.*;

public class LC2192_getAncestors {
    public static void main(String[] args) {
        int[][] graph = {{3, 6}, {2, 4}, {8, 6}, {7, 4}, {1, 4}, {2, 1}, {7, 2}, {0, 4}, {5, 0}, {4, 6}, {3, 2}, {5, 6}, {1, 6}};
        System.out.println(getAncestors(9, graph));
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> listOfAncestors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listOfAncestors.add(new ArrayList<>());
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            findAncestors(listOfAncestors, graph, i, i, new boolean[n]);
        }

        return listOfAncestors;
    }

    private static void findAncestors(List<List<Integer>> listOfAncestors, ArrayList<Integer>[] graph, int parent, int node, boolean[] visited) {
        visited[node] = true;

        for (int current : graph[node]) {
            if (!visited[current]) {
                listOfAncestors.get(current).add(parent);
                findAncestors(listOfAncestors, graph, parent, current, visited);
            }
        }
    }

}
