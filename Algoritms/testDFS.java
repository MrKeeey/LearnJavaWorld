package Algoritms;

import PracticeTasks.TreeNode;
public class testDFS {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        new testDFS().dfsPreOrder(tree);
        System.out.println();
        new testDFS().dfsInOrder(tree);
        System.out.println();
        new testDFS().dfsPostOrder(tree);
    }

    public void dfsPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Посещаем узел сначала - PreOrder
        dfsPreOrder(node.left);
        dfsPreOrder(node.right);
    }

    public void dfsInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsInOrder(node.left);
        System.out.print(node.val + " "); // Посещаем узел между обходом левого и правого поддеревьев - InOrder
        dfsInOrder(node.right);
    }

    public void dfsPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsPostOrder(node.left);
        dfsPostOrder(node.right);
        System.out.print(node.val + " "); // Посещаем узел в конце - PostOrder
    }

}
