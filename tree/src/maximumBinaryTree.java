import java.util.Stack;

public class maximumBinaryTree {

    //  654. Maximum Binary Tree

    //  Using Divide and Conquer

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;

        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = build(nums, left, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, right);

        return root;
    }

    //  Using Stack

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        Stack<TreeNode> stack = new Stack();
        if (nums == null) {
            return null;
        }

        for (int i : nums) {
            TreeNode root = new TreeNode(i);
            while (!stack.isEmpty() && stack.peek().val < root.val) {
                root.left = stack.pop();

            }
            if (!stack.isEmpty()) {
                stack.peek().right = root;
            }
            stack.push(root);
        }
        if(stack.size() > 1) {
            while(stack.size() > 1) {
                stack.pop();
            }
        }
        return stack.peek();
    }
}
