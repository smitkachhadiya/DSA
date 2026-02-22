public class addOneRowToTree {

    //  623. Add One Row to Tree

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        return add(root, val, depth, 1);
    }

    public TreeNode add(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;

        if (curr == depth - 1) {
            TreeNode l = root.left;
            TreeNode r = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = l;
            root.right.right = r;

            return root;
        }

        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);

        return root;
    }
}
