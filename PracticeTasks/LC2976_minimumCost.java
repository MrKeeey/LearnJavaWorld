package PracticeTasks;

import java.util.*;

public class LC2976_minimumCost {
    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost("abcd", "acbe", original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int noWay = Integer.MAX_VALUE / 2;
        int[][] dist = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], noWay);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        // Алгоритм Флойда-Уоршелла для нахождения всех кратчайших путей
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] < noWay) {
                    for (int j = 0; j < 26; j++) {
                        if (dist[k][j] < noWay) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }

        long minCost = 0L;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (dist[from][to] == noWay) {
                return -1;
            }
            minCost += dist[from][to];
        }

        return minCost;
    }

    //Time Limit
    public static long minimumCost2(String source, String target, char[] original, char[] changed, int[] cost) {
        long minCost = 0;
        Map<Character, List<Pairs>> graph = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();

        for (char c : source.toCharArray()) usedChars.add(c);
        for (char c : target.toCharArray()) usedChars.add(c);
        for (char c : original) usedChars.add(c);
        for (char c : changed) usedChars.add(c);

        for (int i = 0; i < original.length; i++) {
            graph.putIfAbsent(original[i], new ArrayList<>());
            graph.get(original[i]).add(new Pairs(changed[i], cost[i]));
        }

        for (int i = 0; i < source.length(); i++) {
            long buffMinCost = getMinDijkstra(source.charAt(i), target.charAt(i), graph, usedChars);
            if (buffMinCost == -1) {
                return -1;
            }
            minCost += buffMinCost;
        }

        return minCost;
    }

    private static long getMinDijkstra(char start, char end, Map<Character, List<Pairs>> graph, Set<Character> usedChars) {
        if (start == end) return 0;

        Map<Character, Integer> distances = new HashMap<>();
        for (char ch : usedChars) {
            distances.put(ch, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Pairs> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pairs::getCost));
        priorityQueue.add(new Pairs(start, 0));

        while (!priorityQueue.isEmpty()) {
            Pairs current = priorityQueue.poll();
            char currentChar = current.getChanged();
            int currentCost = current.getCost();

            if (currentChar == end) {
                return currentCost;
            }

            if (graph.containsKey(currentChar)) {
                for (Pairs neighbor : graph.get(currentChar)) {
                    int newCost = currentCost + neighbor.getCost();
                    if (newCost < distances.get(neighbor.getChanged())) {
                        distances.put(neighbor.getChanged(), newCost);
                        priorityQueue.add(new Pairs(neighbor.getChanged(), newCost));
                    }
                }
            }
        }

        return -1;
    }
}

class Pairs {
    Character changed;
    Integer cost;

    public Pairs(Character changed, Integer cost) {
        this.changed = changed;
        this.cost = cost;
    }

    public Character getChanged() {
        return changed;
    }

    public Integer getCost() {
        return cost;
    }
}
