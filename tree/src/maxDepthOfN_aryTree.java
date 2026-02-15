import java.util.Arrays;

public class maxDepthOfN_aryTree {

    //  559. Maximum Depth of N-ary Tree

    public static int maxDepth(Node root) {
        if(root == null)
            return 0;
        if(root.children.size() == 0)
            return 1;
        int ans = Integer.MIN_VALUE;
        for(Node node : root.children)
            ans = Math.max(ans, maxDepth(node) + 1);
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(3, Arrays.asList(new Node(5), new Node(6))));
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        maxDepthOfN_aryTree tree = new maxDepthOfN_aryTree();
        System.out.println(tree.maxDepth(root));
    }
}
