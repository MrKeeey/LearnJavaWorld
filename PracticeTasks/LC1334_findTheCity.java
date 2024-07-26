package PracticeTasks;

import java.util.*;

public class LC1334_findTheCity {
    public static void main(String[] args) {
        int[][] array = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(findTheCity(4, array, 4));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            distances[from][to] = weight;
            distances[to][from] = weight;
        }

        int[] countCities = new int[n];
        for (int i = 0; i < n; i++) {
            dijkstra(distances, countCities, i, distanceThreshold);
        }
        System.out.println(Arrays.toString(countCities));

        int minCount = Integer.MAX_VALUE;
        int resultCity = -1;
        for (int i = 0; i < n; i++) {
            if (countCities[i] <= minCount) {
                minCount = countCities[i];
                resultCity = i;
            }
        }

        return resultCity;
    }

    public static void dijkstra(int[][] distances, int[] countCities, int start, int distanceThreshold) {
        int n = distances.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            if (visited[u]) continue;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && distances[u][v] != Integer.MAX_VALUE) {
                    int newDist = dist[u] + distances[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        pq.offer(new int[]{v, newDist});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != start && dist[i] <= distanceThreshold) {
                countCities[start]++;
            }
        }
    }
}
