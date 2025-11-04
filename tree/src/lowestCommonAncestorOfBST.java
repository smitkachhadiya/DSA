public class lowestCommonAncestorOfBST {

    //  235. Lowest Common Ancestor of a Binary Search Tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int current = root.val;

        if(current < p.val && current < q.val){
            return lowestCommonAncestor2(root.right,p,q);
        }
        if(current > p.val && current > q.val){
            return lowestCommonAncestor2(root.left,p,q);
        }
        return root;
    }
}
