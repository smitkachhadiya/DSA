public class serializeAndDeserializeBST {

    //  449. Serialize and Deserialize BST

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder("");
        if(root == null) return result.toString();

        serializeHelper(root,result);
        return result.toString();
    }

    public void serializeHelper(TreeNode root,StringBuilder result){
        if(root == null) return;
        result.append(root.val).append(",");
        serializeHelper(root.left,result);
        serializeHelper(root.right,result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        if(len == 0)return null;

        String temp[] = data.split(",");
        int n = temp.length;
        TreeNode root = new TreeNode(Integer.parseInt(temp[0]));

        for(int i =1;i<n;i++){
            int val = Integer.parseInt(temp[i]);
            deserializeHelper(root,val);
        }
        return root;
    }

    public TreeNode deserializeHelper(TreeNode root,int data){
        if(root == null) return new TreeNode(data);

        if(data <= root.val){
            if(root.left == null) root.left = new TreeNode(data);
            else root.left = deserializeHelper(root.left,data);
        }
        else{
            if(root.right == null) root.right = new TreeNode(data);
            else root.right = deserializeHelper(root.right,data);
        }
        return root;
    }
}
