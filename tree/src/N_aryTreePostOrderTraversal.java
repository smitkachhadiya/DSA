import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_aryTreePostOrderTraversal {

    //  590. N-ary Tree Postorder Traversal

    public static List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    private static void dfs(Node root,List<Integer> ans){
        if(root == null) return;
        for(Node child : root.children){
            dfs(child,ans);
        }
        ans.add(root.val);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(3, Arrays.asList(new Node(5), new Node(6))));
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        N_aryTreePreorderTraversal traversal = new N_aryTreePreorderTraversal();
        System.out.println(traversal.preorder(root));
    }
}
