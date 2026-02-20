public class deleteNodeInBST {

    //  450. Delete Node in a BST

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode t = successor(root.right);
                root.val = t.val;
                root.right = deleteNode(root.right, t.val);
            }
        }
        return root;
    }

    TreeNode successor(TreeNode n) {
        while (n.left != null)
            n = n.left;
        return n;
    }
}
