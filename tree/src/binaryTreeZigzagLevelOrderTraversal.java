import java.util.*;

public class binaryTreeZigzagLevelOrderTraversal {

    //  103. Binary Tree Zigzag Level Order Traversal

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ltrLogic = -1;

        while (!queue.isEmpty()) {
            ltrLogic *= -1;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                if (polled.left != null) queue.add(polled.left);
                if (polled.right != null) queue.add(polled.right);
                list.add(polled.val);
            }

            if (ltrLogic == -1)
                Collections.reverse(list);

            ans.add(list);
        }

        return ans;
    }


}
