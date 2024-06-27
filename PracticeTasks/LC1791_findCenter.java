package PracticeTasks;

public class LC1791_findCenter {
    public static void main(String[] args) {
        int[][] array = {{2, 3}, {1, 2}, {4, 2}};
        System.out.println(new LC1791_findCenter().findCenter(array));
    }

    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0]
                || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }
}
