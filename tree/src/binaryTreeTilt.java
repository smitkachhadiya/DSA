public class binaryTreeTilt {

    //  563. Binary Tree Tilt

    int sum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        var left = helper(node.left);
        var right = helper(node.right);

        sum += Math.abs(left - right);

        return left + right + node.val;
    }
}
