package PracticeTasks;

import java.util.*;

public class LC2471_minimumOperations {
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int[] nodeValues = new int[queueSize];

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                nodeValues[i] = node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            count += countMinSwaps(nodeValues);
        }

        return count;
    }

    private int countMinSwaps(int[] nodeValues) {
        int swaps = 0;
        int[] sortedValues = nodeValues.clone();
        Arrays.sort(sortedValues);

        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nodeValues.length; i++) {
            indexes.put(nodeValues[i], i);
        }

        for (int i = 0; i < nodeValues.length; i++) {
            if (nodeValues[i] != sortedValues[i]){
                swaps++;
                int currIndex = indexes.get(sortedValues[i]);
                indexes.put(nodeValues[i], currIndex);
                nodeValues[currIndex] = nodeValues[i];
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(4, new TreeNode(7), new TreeNode(6)),
                new TreeNode(3, new TreeNode(8, new TreeNode(9), null), new TreeNode(5, new TreeNode(10), null)));
        System.out.println(new LC2471_minimumOperations().minimumOperations(treeNode));
    }
}
