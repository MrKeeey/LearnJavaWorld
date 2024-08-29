package PracticeTasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC947_removeStones {
    public static void main(String[] args) {
        int[][] stones = {{0, 1}, {0, 0}, {1, 0}, {2, 2}, {2, 1}, {1, 2}};
        System.out.println(new LC947_removeStones().removeStones(stones));
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind(20002);

        for (int[] stone : stones) {
            unionFind.union(stone[0], stone[1] + 10001);
        }

        return n - unionFind.count;
    }

    class UnionFind {
        int[] parent;
        int count;
        Set<Integer> uniqueNodes;

        public UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            count = 0;
            uniqueNodes = new HashSet<>();
        }

        int find(int node) {
            if (!uniqueNodes.contains(node)) {
                count++;
                uniqueNodes.add(node);
            }
            if (parent[node] == -1) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) return;

            parent[root1] = root2;
            count--;
        }
    }
}
