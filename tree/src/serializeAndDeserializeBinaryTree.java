import java.util.LinkedList;
import java.util.Queue;

public class serializeAndDeserializeBinaryTree {

    //  297. Serialize and Deserialize Binary Tree

    StringBuilder s;

    void preorder(TreeNode root) {
        if (root == null) {
            s.append("null,");
            return;
        }
        s.append(root.val).append(",");
        preorder(root.left);
        preorder(root.right);
    }

    public String serialize(TreeNode root) {
        s = new StringBuilder();
        preorder(root);
        return s.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] s = data.split(",");
        return buildTree(s);
    }


    int index = 0;

    TreeNode buildTree(String[] s) {
        if (s[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[index++]));
        root.left = buildTree(s);
        root.right = buildTree(s);
        return root;
    }

    //  Using Level-order

    public String serialize2(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null,");
                continue;
            }
            sb.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data.equals("null")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
