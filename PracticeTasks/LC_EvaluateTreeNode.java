package PracticeTasks;

public class LC_EvaluateTreeNode {
    public static void main(String[] args) {
        // 0 = false; 1 = true; 2 = OR; 3 = AND;
        TreeNodes tree = new TreeNodes(3, new TreeNodes(1), new TreeNodes(3, new TreeNodes(0), new TreeNodes(1)));
        System.out.println(evaluateTree(tree));
    }

    public static boolean evaluateTree(TreeNodes root) {
        boolean result = false;
        if (root.val == 2) {
            result = evaluateTree(root.left) || evaluateTree(root.right);;
        }
        if (root.val == 3) {
            result = evaluateTree(root.left) && evaluateTree(root.right);
        }
        if (root.val == 1) {
            result = true;
        }
        if (root.val == 0) {
            result = false;
        }
        return result;
    }
}

class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;

    TreeNodes() {
    }

    TreeNodes(int val) {
        this.val = val;
    }

    TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNodes{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
