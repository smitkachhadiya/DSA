import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal {

    //  429. N-ary Tree Level Order Traversal

    //  Level Order Traversal using DFS (recursion)

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result, 0);
        return result;
    }

    public void helper(Node node, List<List<Integer>> result, int level){
        if(node == null) return;
        if(result.size() <= level) result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        List<Node> childList = node.children;
        for(int i=0;i<childList.size();i++){
            Node childNode = childList.get(i);
            helper(childNode, result, level+1);
        }
    }

    //  Level Order Traversal using Queue , BFS

    public List<List<Integer>> levelOrder2(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                q.addAll(curr.children);
                level.add(curr.val);
            }
            ans.add(level);
        }
        return ans;
    }
}
