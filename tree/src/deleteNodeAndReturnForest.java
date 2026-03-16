import java.util.ArrayList;
import java.util.List;

public class deleteNodeAndReturnForest {

    //  1110. Delete Nodes And Return Forest

    private boolean[] toDelete = new boolean[1001];
    private List<TreeNode> forest = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int val : to_delete) {
            toDelete[val] = true;
        }
        dfs(root, true);
        return forest;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot) {
        if (node == null) return null;
        boolean shouldDelete = toDelete[node.val];

        if (isRoot && !shouldDelete) {
            forest.add(node);
        }

        node.left = dfs(node.left, shouldDelete);
        node.right = dfs(node.right, shouldDelete);

        return shouldDelete ? null : node;
    }
}
