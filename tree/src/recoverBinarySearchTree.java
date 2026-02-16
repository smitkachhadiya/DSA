public class recoverBinarySearchTree {

    //  99. Recover Binary Search Tree

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode node){
        if(node == null) return;

        helper(node.left);
        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            second = node;
        }
        prev = node;
        helper(node.right);
    }
}
