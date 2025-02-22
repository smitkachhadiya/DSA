import java.util.ArrayDeque;
import java.util.Deque;

public class recoverATreeFromPreorderTravesal {

    // 1028. Recover a Tree From Preorder Traversal

    public static TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0;
        int n = traversal.length();

        while (i < n){
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            int num = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                num = num * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(num);

            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        TreeNode root = recoverFromPreorder("1-2--3--4-5--6--7");

    }
}
