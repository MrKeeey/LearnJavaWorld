package PracticeTasks;

public class LC_DistributeCoins {
    static int result = 0;
    public static void main(String[] args) {
        TreeNodes tree = new TreeNodes(0, new TreeNodes(0, new TreeNodes(4), new TreeNodes(0)), new TreeNodes(2, new TreeNodes(1), new TreeNodes(0)));
        System.out.println(distributeCoins(tree));
        System.out.println(tree);
    }

    public static int distributeCoins(TreeNodes root) {
        countWays(root);
        return result;
    }

    public static int countWays(TreeNodes root) {
        if (root == null) return 0;

        int left = countWays(root.left);
        int right = countWays(root.right);

        result += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left + right;
    }
}
