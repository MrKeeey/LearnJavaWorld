package PracticeTasks;

import java.util.*;

public class LC515_largestValues {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> maxNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                maxValue = Math.max(maxValue, currentNode.val);

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            maxNodes.add(maxValue);
        }

        return maxNodes;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(new LC515_largestValues().largestValues(treeNode));
    }
}
