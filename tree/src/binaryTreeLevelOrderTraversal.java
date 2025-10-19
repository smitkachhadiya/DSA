import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  102. Binary Tree Level Order Traversal

public class binaryTreeLevelOrderTraversal {

    //  Level Order Traversal using DFS (recursion)

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    void helper(TreeNode root, int level, List<List<Integer>> ans){
        if (root == null) return;
        if (level == ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);

        helper(root.left, level + 1 , ans);
        helper(root.right, level+1 , ans);

    }

    //  Level Order Traversal using Queue , BFS

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int n = q.size();
            for (int i =0; i< n ; i++){
                TreeNode front = q.poll();
                row.add(front.val);
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
            ans.add(row);
        }
        return ans;
    }
}
