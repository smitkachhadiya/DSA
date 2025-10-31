import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevelInBinaryTree {

    //  637. Average of Levels in Binary Tree

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int level = queue.size();
            double sum = 0;

            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(sum/level);
        }

        return ans;
    }
}
