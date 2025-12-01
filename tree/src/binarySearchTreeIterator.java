import java.util.ArrayList;
import java.util.List;

public class binarySearchTreeIterator {

    //  173. Binary Search Tree Iterator

    static class BSTIterator {
        List<Integer> inorder = new ArrayList<>();
        int i = 0;

        public BSTIterator(TreeNode root) {
            inorderCreation(root);
        }

        private void inorderCreation(TreeNode root) {
            if (root == null) return;
            inorderCreation(root.left);
            inorder.add(root.val);
            inorderCreation(root.right);
        }

        public int next() {
            return inorder.get(i++);
        }

        public boolean hasNext() {
            return i < inorder.size();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bSTIterator = new BSTIterator(root);

        System.out.println(bSTIterator.next());    // 3
        System.out.println(bSTIterator.next());    // 7
        System.out.println(bSTIterator.hasNext()); // true
        System.out.println(bSTIterator.next());    // 9
        System.out.println(bSTIterator.hasNext()); // true
        System.out.println(bSTIterator.next());    // 15
        System.out.println(bSTIterator.hasNext()); // true
        System.out.println(bSTIterator.next());    // 20
        System.out.println(bSTIterator.hasNext()); // false

    }

}
