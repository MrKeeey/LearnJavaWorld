package PracticeTasks;

import java.util.*;

public class LC1382_balanceBST {
    private final ArrayList<Integer> treeList = new ArrayList<>();

    public static void main(String[] args) {
        LC1382_balanceBST my = new LC1382_balanceBST();
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(my.balanceBST(treeNode));
    }

    public TreeNode balanceBST(TreeNode root) {
        addTreeToList(root);
        return makeBalancedTree(0 , treeList.size() - 1);
    }

    private TreeNode makeBalancedTree(int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode balancedTree = new TreeNode(treeList.get(mid));

        balancedTree.left = makeBalancedTree(left, mid - 1);
        balancedTree.right = makeBalancedTree(mid + 1, right);

        return balancedTree;
    }

    private void addTreeToList(TreeNode root) {
        if (root != null) {
            addTreeToList(root.left);
            treeList.add(root.val);
            addTreeToList(root.right);
        }
    }
}
