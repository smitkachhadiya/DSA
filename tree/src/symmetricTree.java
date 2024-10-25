import com.sun.source.tree.Tree;

public class symmetricTree {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    // 101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left , root.right);
    }

    public boolean isMirror(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return (left.val == right.val) && isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

}
