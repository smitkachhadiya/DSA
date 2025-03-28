import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_aryTreePreorderTraversal {

    // 589. N-ary Tree Preorder Traversal

    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public static void dfs(Node node,List<Integer> ans){
        if(node == null){
            return;
        }

        ans.add(node.val);
        for (Node child : node.children){
            dfs(child,ans);
        }
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
