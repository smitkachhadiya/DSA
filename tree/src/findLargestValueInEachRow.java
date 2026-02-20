import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findLargestValueInEachRow {

    //  515. Find Largest Value in Each Tree Row

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()){
            int small = Integer.MIN_VALUE;
            int n = q.size();
            for (int i =0; i< n ; i++){
                TreeNode front = q.poll();
                if(front.val > small) small = front.val;
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
            ans.add(small);
        }
        return ans;
    }
}
