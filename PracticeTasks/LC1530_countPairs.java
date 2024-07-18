package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC1530_countPairs {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(new LC1530_countPairs().countPairs(tree, 3));
    }

    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private List<Integer> dfs(TreeNode root, int distance, int[] result) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            List<Integer> leafDistance = new ArrayList<>();
            leafDistance.add(1);
            return leafDistance;
        }

        List<Integer> leftDistance = dfs(root.left, distance, result);
        List<Integer> rightDistance = dfs(root.right, distance, result);

        for (int leftDist : leftDistance) {
            for (int rightDist : rightDistance) {
                if (leftDist + rightDist <= distance) {
                    result[0]++;
                }
            }
        }

        List<Integer> currentDistance = new ArrayList<>();
        for (int dist : leftDistance) {
            currentDistance.add(dist + 1);
        }
        for (int dist : rightDistance) {
            currentDistance.add(dist + 1);
        }

        return currentDistance;
    }

}
