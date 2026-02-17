import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftTreeValue {

    //  513. Find Bottom Left Tree Value

    //  Using DFS

    int maxDepth = 0;
    int lastNode;

    public int findBottomLeftValue(TreeNode root) {
        lastNode = root.val;
        dfs(root, 0);
        return lastNode;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        if (level>maxDepth) {
            maxDepth = level;
            lastNode = root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    //  Using BFS

    public int findBottomLeftValue2(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    ans = curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return ans;
    }
}
