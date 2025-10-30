import java.util.ArrayList;
import java.util.List;

public class pathSum2 {

    //  113. Path Sum II

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,targetSum,0,ans,new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode root,int targetSum,int cSum,List<List<Integer>> ans,List<Integer> cPath){
        if(root == null) return;

        cSum += root.val;
        cPath.add(root.val);

        if(root.left == null && root.right == null && cSum == targetSum){
            ans.add(new ArrayList<>(cPath));
        }

        dfs(root.left,targetSum,cSum,ans,cPath);
        dfs(root.right,targetSum,cSum,ans,cPath);
        cPath.remove(cPath.size()-1);
    }
}
