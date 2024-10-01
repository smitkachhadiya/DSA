import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    private static class TreeNode {
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

    TreeNode root;

    // 257. Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null){
            path(root,"",list);
        }
        return list;
    }

    public void path(TreeNode node,String p,List<String> list){
        if (node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            p += node.val;
            list.add(p);
        }
        p += (node.val+"->");
        path(node.left, p, list);
        path(node.right, p, list);
    }

    public static void main(String[] args) {
        binaryTreePaths tree = new binaryTreePaths();
//        tree.root = new TreeNode(6);
//        tree.root.left = new TreeNode(3);
//        tree.root.right = new TreeNode(5);
//        tree.root.right.right = new TreeNode(4);
//        tree.root.left.left = new TreeNode(2);
//        tree.root.left.right = new TreeNode(5);
//        tree.root.left.right.right = new TreeNode(4);
//        tree.root.left.right.left = new TreeNode(7);
    }
}
