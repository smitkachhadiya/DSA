public class longestUnivaluePath {

    //  687. Longest Univalue Path

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root,-1);
        return ans;
    }

    public int helper(TreeNode node, int curr){
        if(node == null) return 0;

        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);

        ans = Math.max(ans, left + right);

        if(node.val == curr)
            return Math.max(left, right) + 1;
        else
            return 0;
    }
}
