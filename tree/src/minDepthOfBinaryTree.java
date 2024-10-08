public class minDepthOfBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0){
            return right+1;
        }
        else if(right==0){
            return left+1;
        }
        return Math.min(left,right)+1;
    }

    // method 2 :
    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if (root.left == null) {
            return minDepth2(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth2(root.left) + 1;
        }
        return Math.min(minDepth2(root.left),minDepth2(root.right)) + 1;
    }
}
