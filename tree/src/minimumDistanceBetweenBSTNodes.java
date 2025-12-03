public class minimumDistanceBetweenBSTNodes {

    //  783. Minimum Distance Between BST Nodes

    Integer res = Integer.MAX_VALUE , previous = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null) minDiffInBST(root.left);
        if(previous != null) res = Math.min(res,root.val - previous);
        previous = root.val;
        if(root.right != null) minDiffInBST(root.right);
        return res;
    }
}
