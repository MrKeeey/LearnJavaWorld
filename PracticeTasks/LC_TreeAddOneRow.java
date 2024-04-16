package PracticeTasks;

public class LC_TreeAddOneRow {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        System.out.println(addOneRow(tree, 1, 2));
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (depth == 2) {
//            TreeNode leftTree = root.left;
//            TreeNode rightTree = root.right;
//            root.left = new TreeNode(val);
//            root.right = new TreeNode(val);
//            root.left.left = leftTree;
//            root.right.right = rightTree;
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return root;
        }
        root.left = addOneRow(root.left, val, depth - 1);
        root.right = addOneRow(root.right, val, depth - 1);
        return root;
    }
}
