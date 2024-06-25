package PracticeTasks;

public class LC_TreeSumOfLeftLeaves {
    public static void main(String[] args) {
        int[] tree = {3, 9, 20, 0, 0, 15, 7};
        TreeNode treeNode = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(sumOfLeftLeaves(tree));
        System.out.println(sumOfLeftLeaves2(treeNode));
    }

    public static int sumOfLeftLeaves(int[] root) {
        if (root.length == 1) return 0;
        int sum = 0;
        for (int i = 1; i < root.length; i += 2) {
            if (i + 2 < root.length && root[i + 2] == 0) {
                sum += root[i];
                i += 2;
            } else if (i + 2 >= root.length) {
                sum += root[i];
            }
        }
        return sum;
    }

    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves2(root.left);
        sum += sumOfLeftLeaves2(root.right);
        return sum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
