import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class findDublicateSubtree {

    //  652. Find Duplicate Subtrees

    HashMap<String,Integer> map = new HashMap<>();
    ArrayList<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return list;
    }

    public String helper(TreeNode root){
        if (root == null) return "N";

        String left = helper(root.left);
        String right = helper(root.right);

        String curr = root.val + " " + left + " " + right;

        map.put(curr , map.getOrDefault(curr,0) + 1);
        if(map.get(curr) == 2){
            list.add(root);
        }

        return curr;
    }

}
