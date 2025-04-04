package PracticeTasks;

import java.util.AbstractMap;
import java.util.Map;

public class LC1123_lcaDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    private Map.Entry<TreeNode, Integer> dfs(TreeNode node) {
        if (node == null) return new AbstractMap.SimpleEntry<>(null, 0);

        Map.Entry<TreeNode, Integer> left = dfs(node.left);
        Map.Entry<TreeNode, Integer> right = dfs(node.right);

        int leftDepth = left.getValue();
        int rightDepth = right.getValue();

        if (leftDepth > rightDepth) {
            return new AbstractMap.SimpleEntry<>(left.getKey(), leftDepth + 1);
        }
        if (leftDepth < rightDepth) {
            return new AbstractMap.SimpleEntry<>(right.getKey(), rightDepth + 1);
        }

        return new AbstractMap.SimpleEntry<>(node, leftDepth + 1);
    }

    private TreeNode result;
    private int maxDepth = 0;

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        dfsPostOrder(root, 0);
        return result;
    }

    public int dfsPostOrder(TreeNode node, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (node == null) return depth;

        int left = dfsPostOrder(node.left, depth + 1);
        int right = dfsPostOrder(node.right, depth + 1);

        if (left == right && left == maxDepth) {
            result = node;
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
//        TreeNode treeNode = new TreeNode(1);
        System.out.println(new LC1123_lcaDeepestLeaves().lcaDeepestLeaves(treeNode));
        System.out.println(new LC1123_lcaDeepestLeaves().lcaDeepestLeaves2(treeNode));
    }
}
