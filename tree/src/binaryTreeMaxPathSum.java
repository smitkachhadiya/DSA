public class binaryTreeMaxPathSum {

    //  124. Binary Tree Maximum Path Sum

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxTreePathSum(root);
        return res;
    }

    int maxTreePathSum(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(0, maxTreePathSum(node.left));
        int right = Math.max(0, maxTreePathSum(node.right));

        int pathSum = left + right + node.val;
        res = Math.max(res, pathSum);

        return Math.max(left, right) + node.val;
    }
}
