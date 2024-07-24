package PracticeTasks;

public class LC988_smallestFromLeaf {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)), new TreeNode(3, new TreeNode(0), new TreeNode(2)));
        System.out.println(smallestFromLeaf(tree));
    }

    static String smallestStr = "";

    public static String smallestFromLeaf(TreeNode root) {
        smallestBranch(root, "");
        return smallestStr;
    }

    public static void smallestBranch(TreeNode root, String currentStr) {
        if (root == null) return;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        currentStr = alphabet.charAt(root.val) + currentStr;

        if (root.left == null && root.right == null) {
            if (smallestStr.isEmpty() || smallestStr.compareTo(currentStr) > 0) {
                smallestStr = currentStr;
            }
        }

        if (root.left != null) {
            smallestBranch(root.left, currentStr);
        }

        if (root.right != null) {
            smallestBranch(root.right, currentStr);
        }
    }
}
