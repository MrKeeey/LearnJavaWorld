package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC145_postorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(postorderTraversal(treeNode));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        return dfsPostOrder(root, new ArrayList<>());
    }

    private static List<Integer> dfsPostOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            dfsPostOrder(root.left, result);
            dfsPostOrder(root.right, result);
            result.add(root.val);
        }
        return result;
    }
}
