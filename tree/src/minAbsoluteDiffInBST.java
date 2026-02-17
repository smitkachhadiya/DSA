public class minAbsoluteDiffInBST {

    //  530. Minimum Absolute Difference in BST

    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        ans = Math.min(ans,Math.abs(root.val - prev));
        prev = root.val;

        inorder(root.right);
    }


}
