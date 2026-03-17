import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class checkCompletenessOfBinaryTree {

    //  958. Check Completeness of a Binary Tree

    // Using DFS

    public boolean isCompleteTree(TreeNode root) {
        int total = count(root);
        return dfs(root , 1 , total);
    }

    public int count(TreeNode root){
        if(root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public boolean dfs(TreeNode root , int i , int total){
        if(root == null) return true;
        if(i > total) return false;
        return dfs(root.left , 2*i , total) && dfs(root.right , 2*i+1 , total);
    }

    // Using BFS

    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

        while (q.peek() != null){
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }

        while (!q.isEmpty() && q.peek() == null){
            q.poll();
        }

        return q.isEmpty();
    }
}
