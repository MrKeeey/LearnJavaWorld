package PracticeTasks;

public class LC1028_recoverFromPreorder {
    private int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return buildTree(0, traversal);
    }

    private TreeNode buildTree(int depth, String s) {
        if (index >= s.length()) return null;

        int count = 0;
        while (index + count < s.length() && s.charAt(index + count) == '-') count++;

        if (count != depth) return null;
        index += count;

        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (s.charAt(index++) - '0');
        }
        TreeNode node = new TreeNode(num);

        node.left = buildTree(depth + 1, s);
        node.right = buildTree(depth + 1, s);

        return node;
    }

    //2 slower
    public TreeNode recoverFromPreorder2(String traversal) {
        int index = 0;
        TreeNode[] parents = new TreeNode[1000];

        while (index < traversal.length()) {
            int depth = 0;

            while (index < traversal.length() && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }

            int value = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);

            if (depth > 0) {
                TreeNode parent = parents[depth - 1];
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            parents[depth] = node;
        }

        return parents[0];
    }


    public static void main(String[] args) {
        System.out.println(new LC1028_recoverFromPreorder().recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(new LC1028_recoverFromPreorder().recoverFromPreorder2("1-2--3--4-5--6--7"));
    }
}
