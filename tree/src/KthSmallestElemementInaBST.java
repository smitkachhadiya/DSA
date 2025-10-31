import java.util.ArrayList;
import java.util.List;

public class KthSmallestElemementInaBST {

    //  230. Kth Smallest Element in a BST

    int result = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root,k);
        return result;
    }

    private void inorderTraversal(TreeNode root,int key){
        if(root==null || result != -1)return;
        inorderTraversal(root.left,key);
        count++;
        if(count == key){
            result = root.val;
            return;
        }
        inorderTraversal(root.right,key);
    }

    //  Method 2 :

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list.get(k-1);
    }

    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
