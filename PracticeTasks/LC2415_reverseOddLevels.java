package PracticeTasks;

public class LC2415_reverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }

    public void dfs(TreeNode leftChild, TreeNode rightChild, int count) {
        if (leftChild == null || rightChild == null) {
            return;
        }

        if (count % 2 == 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }

        dfs(leftChild.left, rightChild.right, count + 1);
        dfs(leftChild.right, rightChild.left, count + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)), new TreeNode(5, new TreeNode(21), new TreeNode(34)));
        System.out.println(new LC2415_reverseOddLevels().reverseOddLevels(treeNode));
    }
}
