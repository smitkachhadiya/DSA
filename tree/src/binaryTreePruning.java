public class binaryTreePruning {

    //  814. Binary Tree Pruning

    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) return null;

        root.left = helper(root.left);
        root.right = helper(root.right);

        if (root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}
