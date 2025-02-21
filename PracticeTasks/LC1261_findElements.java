package PracticeTasks;

import java.util.*;

public class LC1261_findElements {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), new TreeNode(-1)), new TreeNode(-1));
        FindElements findElements = new FindElements(treeNode);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(5));
    }
}

class FindElements {
    BitSet values;

    public FindElements(TreeNode root) {
        values = new BitSet();
        root.val = 0;
        dfs(root);
//        bfs(root);
    }

    public boolean find(int target) {
        return values.get(target);
    }

    private void dfs(TreeNode node) {
        values.set(node.val);

        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            dfs(node.left);
        }

        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            dfs(node.right);
        }
    }

    private void bfs(TreeNode root) {
        if (root == null) return;

        values.set(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                node.left.val = 2 * node.val + 1;
                values.set(node.left.val);
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val = 2 * node.val + 2;
                values.set(node.right.val);
                queue.add(node.right);
            }
        }
    }
}
