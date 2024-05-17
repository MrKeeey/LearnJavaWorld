package PracticeTasks;

public class LC_RemoveLeafNodes {
    public static void main(String[] args) {
        TreeNodes tree = new TreeNodes(1, new TreeNodes(2, new TreeNodes(2), null), new TreeNodes(3, new TreeNodes(2), new TreeNodes(4)));
        System.out.println(removeLeafNodes(tree, 2));
    }

    public static TreeNodes removeLeafNodes(TreeNodes root, int target) {
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
