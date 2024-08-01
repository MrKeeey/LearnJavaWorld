package PracticeTasks;

public class LC1971_validPath {
    public static void main(String[] args) {
        int[][] array = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {5, 4}};
        System.out.println(validPath(6, array, 0, 5));
        System.out.println(validPath2(6, array, 0, 5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0 || edges[0].length == 0) {
            return n == 1 && source == 0 && destination == 0;
        }
        boolean flag = true;
        boolean[] isCheked = new boolean[n];
        isCheked[source] = true;

        while (flag) {
            flag = false;
            for (int[] edge : edges) {
                if (isCheked[edge[0]] != isCheked[edge[1]]) {
                    isCheked[edge[0]] = true;
                    isCheked[edge[1]] = true;
                    flag = true;
                }
                if (isCheked[destination]) return true;
            }
        }
        return false;
    }

    public static boolean validPath2(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0 || edges[0].length == 0) {
            return n == 1 && source == 0 && destination == 0;
        }
        return check(new boolean[edges.length][2], edges, source, destination);
    }
    
    public static boolean check (boolean[][] isChecked, int[][] edges, int source, int destination) {
        boolean result = false;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == source && !isChecked[i][0]) {
                isChecked[i][0] = true;
                if (edges[i][1] == destination) {
                    return true;
                } else {
                    isChecked[i][1] = true;
                    result = check(isChecked, edges, edges[i][1], destination);
                    if (result) return true;
                }
            } else if (edges[i][1] == source && !isChecked[i][1]) {
                isChecked[i][1] = true;
                if (edges[i][0] == destination) {
                    return true;
                } else {
                    isChecked[i][0] = true;
                    result = check(isChecked, edges, edges[i][0], destination);
                    if (result) return true;
                }
            }
        }
        return result;
    }
}
