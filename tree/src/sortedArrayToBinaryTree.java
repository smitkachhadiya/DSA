import com.sun.source.tree.Tree;

public class sortedArrayToBinaryTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return populateSorted(nums,0,nums.length);
    }

    private TreeNode populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left =  populateSorted(nums, start, mid);
        root.right =  populateSorted(nums, mid + 1, end);
        return root;
    }
}
