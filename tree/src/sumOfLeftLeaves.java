public class sumOfLeftLeaves {

    //  404. Sum of Left Leaves

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }
        int leftSum = dfs(node.left, true);
        int rightSum = dfs(node.right, false);
        return leftSum + rightSum;
    }
}
