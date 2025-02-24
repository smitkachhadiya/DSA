public class constructBinaryTreeFromPreorderAndPostorder {

    private int preIdx = 0;
    private int postIdx = 0;

    // 889. Construct Binary Tree from Preorder and Postorder Traversal

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode curr = new TreeNode(preorder[preIdx]);
        preIdx++;

        if (curr.val != postorder[postIdx]) {
            curr.left = constructFromPrePost(preorder, postorder);
        }
        if (curr.val != postorder[postIdx]) {
            curr.right = constructFromPrePost(preorder, postorder);
        }

        postIdx++;
        return curr;

    }

}
