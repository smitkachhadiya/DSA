import java.util.LinkedList;
import java.util.Queue;

class CBTInserter{

    //  919. Complete Binary Tree Inserter

    TreeNode root;
    Queue<TreeNode> q = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);

        while(!temp.isEmpty()){
            TreeNode node = temp.poll();
            if(node.left == null || node.right == null) q.offer(node);
            if(node.left != null) temp.offer(node.left);
            if(node.right != null) temp.offer(node.right);
        }
    }

    public int insert(int val) {
        TreeNode parent = q.peek();
        TreeNode node = new TreeNode(val);
        if(parent.left == null)
            parent.left = node;
        else{
            parent.right = node;
            q.poll();
        }
        q.offer(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

public class completeBinaryTreeInsert {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        CBTInserter cBTInserter = new CBTInserter(root);
        System.out.println(cBTInserter.insert(3));
        System.out.println(cBTInserter.insert(4));
        TreeNode resultRoot = cBTInserter.get_root();
    }
}
