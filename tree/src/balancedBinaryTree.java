import javax.print.DocFlavor;

public class balancedBinaryTree {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 110. Balanced Binary Tree

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        if(leftHeight < 0){
            return -1;
        }

        int rightHeight = height(node.right);
        if(rightHeight < 0){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
