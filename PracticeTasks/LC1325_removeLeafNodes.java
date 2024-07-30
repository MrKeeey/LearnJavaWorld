package PracticeTasks;

public class LC1325_removeLeafNodes {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        System.out.println(removeLeafNodes(tree, 2));
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }
        if (root.val == target && root.left == null && root.right == null) {
            root = null;
        }
        return root;
    }
}
