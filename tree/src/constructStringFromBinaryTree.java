public class constructStringFromBinaryTree {

    //  606. Construct String from Binary Tree

    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(root, ans);
        return ans.toString();
    }

    public void dfs(TreeNode node, StringBuilder ans){
        if(node == null) return;
        ans.append(node.val);
        if(node.left != null || node.right != null){
            ans.append('(');
            dfs(node.left, ans);
            ans.append(')');
        }

        if(node.right != null){
            ans.append('(');
            dfs(node.right, ans);
            ans.append(')');
        }
    }
}
