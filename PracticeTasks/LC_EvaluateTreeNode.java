package PracticeTasks;

public class LC_EvaluateTreeNode {
    public static void main(String[] args) {
        // 0 = false; 1 = true; 2 = OR; 3 = AND;
        TreeNode tree = new TreeNode(3, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));
        System.out.println(evaluateTree(tree));
    }

    public static boolean evaluateTree(TreeNode root) {
        boolean result = false;
        if (root.val == 2) {
            result = evaluateTree(root.left) || evaluateTree(root.right);;
        }
        if (root.val == 3) {
            result = evaluateTree(root.left) && evaluateTree(root.right);
        }
        if (root.val == 1) {
            result = true;
        }
        if (root.val == 0) {
            result = false;
        }
        return result;
    }
}