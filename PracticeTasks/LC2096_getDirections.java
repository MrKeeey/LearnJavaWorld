package PracticeTasks;

public class LC2096_getDirections {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(1, new TreeNode(3), null), new TreeNode(2, new TreeNode(6), new TreeNode(4)));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1), null);
        System.out.println(new LC2096_getDirections().getDirections(treeNode, 3, 6));
        System.out.println(new LC2096_getDirections().getDirections(treeNode2, 2, 1));
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startWay = new StringBuilder();
        StringBuilder destWay = new StringBuilder();
        StringBuilder path = new StringBuilder();
        boolean[] found = new boolean[2];

        makeStartAndDestWays(root, startValue, destValue, path, startWay, destWay, found);

        int i = 0;
        while (i < startWay.length() && i < destWay.length() && startWay.charAt(i) == destWay.charAt(i)) {
            i++;
        }

        return "U".repeat(startWay.length() - i) + destWay.substring(i);
    }

    private boolean makeStartAndDestWays(TreeNode root, int startValue, int destValue, StringBuilder path, StringBuilder startWay, StringBuilder destWay, boolean[] found) {
        if (root == null) {
            return false;
        }

        if (root.val == startValue) {
            startWay.append(path);
            found[0] = true;
        }

        if (root.val == destValue) {
            destWay.append(path);
            found[1] = true;
        }

        if (found[0] && found[1]) {
            return true;
        }

        if (root.left != null) {
            path.append("L");
            if (makeStartAndDestWays(root.left, startValue, destValue, path, startWay, destWay, found)) {
                return true;
            }
            path.setLength(path.length() - 1);
        }

        if (root.right != null) {
            path.append("R");
            if (makeStartAndDestWays(root.right, startValue, destValue, path, startWay, destWay, found)) {
                return true;
            }
            path.setLength(path.length() - 1);
        }
        return false;
    }
}
