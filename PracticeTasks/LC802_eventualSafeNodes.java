package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC802_eventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, graph, visited, inStack);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!inStack[i]) result.add(i);
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] inStack) {
        if (inStack[node]) return true;
        if (visited[node]) return false;

        inStack[node] = true;
        visited[node] = true;

        for (int nextNode : graph[node]) {
            if (dfs(nextNode, graph, visited, inStack)) return true;
        }

        inStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(new LC802_eventualSafeNodes().eventualSafeNodes(graph));
    }
}
