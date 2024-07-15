package PracticeTasks;

import java.util.*;

public class LC2196_createBinaryTree {
    public static void main(String[] args) {
        int[][] tree = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        System.out.println(createBinaryTree(tree));
    }

    //создать бинарное дерево с помощью очереди Queue - LinkedList
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> rootNode = new HashSet<>();
        HashSet<Integer> childs = new HashSet<>();
        Map<Integer, List<int[]>> mapParents = new HashMap<>();

        for (int[] description : descriptions) {
            rootNode.add(description[0]);
            childs.add(description[1]);

//            int[] buff = {description[1], description[2]};
//            List<int[]> temp = new ArrayList<>();
//
//            if (mapParents.containsKey(description[0])) {
//                temp = mapParents.get(description[0]);
//            }
//
//            temp.add(buff);
//            mapParents.put(description[0], temp);
            mapParents.computeIfAbsent(description[0], x -> new ArrayList<>())
                    .add(new int[] {description[1], description[2]});
        }

        rootNode.removeAll(childs);
        TreeNode root = new TreeNode(rootNode.iterator().next());
        Queue<TreeNode> childNodes = new LinkedList<>();
        childNodes.offer(root);

        while (!childNodes.isEmpty()) {
            TreeNode parent = childNodes.poll();
            if (mapParents.get(parent.val) != null) {
                for (int[] childInfo : mapParents.get(parent.val)) {
                    TreeNode child = new TreeNode(childInfo[0]);
                    childNodes.offer(child);
                    if (childInfo[1] == 1) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                }
            }
        }

        return root;
    }
}
