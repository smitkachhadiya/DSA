import java.util.ArrayList;
import java.util.List;

public class allNodesDistanceKInBinaryTree {

    //  863. All Nodes Distance K in Binary Tree

    List<Integer> list = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target.val, k, 0);
        return list;
    }

    private int dfs(TreeNode node, int target, int k, int i) {
        if (node == null) {
            return -1;
        }
        if (node.val == target) {
            helper(node, k );
            return 1;
        }
        int left = dfs(node.left, target, k, i + 1);
        if (left != -1) {
            if (left == k) {
                list.add(node.val);
            } else {
                helper(node.right, k - left-1);
            }
            return left + 1;
        }
        int right = dfs(node.right, target, k, i + 1);
        if (right != -1) {
            if (right == k) {
                list.add(node.val);
            } else {
                helper(node.left, k - right-1);
            }
            return right + 1;
        }
        return -1;

    }

    private void helper(TreeNode node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            list.add(node.val);
            return;
        }
        helper(node.left, k - 1);
        helper(node.right, k - 1);
    }

}
