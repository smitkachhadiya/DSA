public class insertIntoBST {

    //  701. Insert into a Binary Search Tree

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) root.left = insertIntoBST(root.left,val);
        if (val > root.val) root.right = insertIntoBST(root.right,val);

        return root;
    }
}
