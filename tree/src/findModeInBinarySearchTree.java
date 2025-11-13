import java.util.ArrayList;
import java.util.List;

public class findModeInBinarySearchTree {

    //  501. Find Mode in Binary Search Tree

    private int current;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> ans= new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] modes = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            modes[i] = ans.get(i);
        }
        return modes;
    }

    public void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);

        currentCount = (node.val == current) ? currentCount + 1 : 1;
        if(currentCount == maxCount){
            ans.add(node.val);
        } else if (currentCount > maxCount){
            maxCount = currentCount;
            ans.clear();
            ans.add(node.val);
        }
        current = node.val;

        inOrder(node.right);
    }
}
