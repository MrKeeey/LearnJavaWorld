package PracticeTasks;

public class LC129_sumNumbers {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0, null, null));
        System.out.println(sumNumbers(tree));
        System.out.println(sumNumbers2(tree));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sum(root, 0);
    }

    public static int sum(TreeNode root, int sumNum) {
        if (root == null) return 0;
        sumNum = sumNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sumNum;
        }
        return sum(root.left, sumNum) + sum(root.right, sumNum);
    }

    public static int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        String result = "";
        return sum2(root, result);
    }

    public static int sum2 (TreeNode root, String result) {
        if (root == null) return 0;
        result += root.val;
        if (root.left == null && root.right == null) {
            return Integer.parseInt(result);
        }
        return Integer.parseInt(String.valueOf(sum2(root.left, result))) + Integer.parseInt(String.valueOf(sum2(root.right, result)));
    }
}