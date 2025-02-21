import java.util.HashSet;

// 1261. Find Elements in a Contaminated Binary Tree

class FindElements {

    private HashSet<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int val) {
        if(node == null){
            return;
        }
        node.val = val;
        values.add(val);

        recoverTree(node.left, 2 * val + 1);
        recoverTree(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}

public class findElementInAContainedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);
        FindElements findElements = new FindElements(root);

        System.out.println(findElements.find(1));
        System.out.println(findElements.find(2));
    }

}


