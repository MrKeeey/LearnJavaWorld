package PracticeTasks;

public class LC889_constructFromPrePost {
    private int preIndex = 0;
    private int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder) {

        TreeNode node = new TreeNode(preorder[preIndex++]);

        if (node.val != postorder[postIndex]) {
            node.left = buildTree(preorder, postorder);
        }
        if (node.val != postorder[postIndex]) {
            node.right = buildTree(preorder, postorder);
        }
        postIndex++;

        return node;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        System.out.println(new LC889_constructFromPrePost().constructFromPrePost(preOrder, postOrder));
    }
}
