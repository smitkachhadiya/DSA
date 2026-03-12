import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class smallestSubtreeWithAllDeepestNodes {

    //  865. Smallest Subtree with all the Deepest Nodes

    private static class Pair {
        int depth;
        TreeNode node;

        Pair(int d, TreeNode n) {
            depth = d;
            node = n;
        }
    }

    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(0, null);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Pair(left.depth + 1, root);
        } else if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.node);
        } else {
            return new Pair(right.depth + 1, right.node);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    //  Method 2

    public TreeNode subtreeWithAllDeepest2(TreeNode root) {
        List<TreeNode> last = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            last = new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode curr = queue.poll();
                last.add(curr);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return LCA(last.get(0), last.get(last.size()-1),root);
    }

    private TreeNode LCA(TreeNode p, TreeNode q, TreeNode root) {

        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = LCA(p, q, root.left);
        TreeNode right = LCA(p, q, root.right);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}
