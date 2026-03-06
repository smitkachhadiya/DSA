import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class maxWidthOfBinaryTree {

    //  662. Maximum Width of Binary Tree

    List<Integer> list;
    int max;

    public int widthOfBinaryTree(TreeNode root) {
        list = new ArrayList<>();
        max = 1;
        helper(root,1,1);
        return max;
    }

    public void helper(TreeNode root,int height,int i) {
        if(root == null){
            return;
        }
        if(list.size() < height) {
            list.add(i);
        }
        else{
            max = Math.max(max, (i - list.get(height - 1)) + 1);
        }
        helper(root.left,height + 1,2*i);
        helper(root.right,height + 1,2*i+1);
    }


    //  using Queue

    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            int levelStart = queue.peek().index;
            int index = 0;

            for (int i = 0; i < levelLength; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                index = pair.index;

                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * index));
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * index + 1));
                }
            }

            maxWidth = Math.max(maxWidth, index - levelStart + 1);
        }

        return maxWidth;
    }
}
