package PracticeTasks;

public class LC1038_bstToGst {
    private int max = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        TreeNode treeNode2 = new TreeNode(0, null, new TreeNode(1));
        System.out.println(new LC1038_bstToGst().bstToGst(treeNode));
        System.out.println(new LC1038_bstToGst().bstToGst(treeNode2));
    }

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            root.val += max;
            max = root.val;
            bstToGst(root.left);
        }
        return root;
    }
}
