package PracticeTasks;

import java.util.*;

public class LC1110_delNodes {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        int[] array = {3, 5};
        System.out.println(new LC1110_delNodes().delNodes(tree, array));
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();

        for (int num : to_delete) {
            toDeleteSet.add(num);
        }

        root = fs(root, toDeleteSet, result);
        if (root != null) {
            result.add(root);
        }

        return result;
    }

    private TreeNode fs(TreeNode root, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left = fs(root.left, toDeleteSet, result);
        }

        if (root.right != null) {
            root.right = fs(root.right, toDeleteSet, result);
        }

        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) result.add(root.left);
            if (root.right != null) result.add(root.right);
            return null;
        }

        return root;
    }
}
