package PracticeTasks;

public class LC979_distributeCoins {
    static int result = 0;
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0, new TreeNode(0, new TreeNode(4), new TreeNode(0)), new TreeNode(2, new TreeNode(1), new TreeNode(0)));
        System.out.println(distributeCoins(tree));
        System.out.println(tree);
    }

    public static int distributeCoins(TreeNode root) {
        countWays(root);
        return result;
    }

    public static int countWays(TreeNode root) {
        if (root == null) return 0;

        int left = countWays(root.left);
        int right = countWays(root.right);

        result += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left + right;
    }
}
