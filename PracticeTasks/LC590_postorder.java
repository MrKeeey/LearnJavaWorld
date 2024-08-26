package PracticeTasks;

import java.util.ArrayList;
import java.util.List;

public class LC590_postorder {
    public static void main(String[] args) {
        List<Node> list2 = new ArrayList<>();
        list2.add(new Node(5));
        list2.add(new Node(6));

        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(3, list2));
        list1.add(new Node(2));
        list1.add(new Node(4));

        Node node = new Node(1, list1);

        System.out.println(postorder(node));
    }

    public static List<Integer> postorder(Node root) {
        return dfsPostOrder(root, new ArrayList<>());
    }

    //Возможно неправильно создается node
    // из-за этого if (root.children != null) {..} нельзя убрать
    private static List<Integer> dfsPostOrder(Node root, List<Integer> result) {
        if (root != null) {
            if (root.children != null) {
                for (Node node : root.children) {
                    dfsPostOrder(node, result);
                }
            }
            result.add(root.val);
        }
        return result;
    }
}
