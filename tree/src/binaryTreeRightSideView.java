import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeRightSideView {

    //  199. Binary Tree Right Side View

    //  Method 1

    public List<Integer> rightSideView(TreeNode root) {
        int level=0;
        List<Integer> ans = new ArrayList<>();
        order(root, level, ans);
        return ans;
    }
    public void order(TreeNode root, int level, List<Integer> ans){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.val);
        }
        order(root.right, level+1, ans);
        order(root.left, level+1, ans);
    }

    //  Method 2 - Level Order Traversal

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
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
            ans.add(row.get(row.size()-1));
        }
        return ans;
    }
}
