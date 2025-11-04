import java.util.HashMap;
import java.util.Map;

public class pathSum3 {

    //  437. Path Sum III

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,0,targetSum,map);
    }

    private int dfs(TreeNode root,long sum, int targetSum, Map<Long,Integer> map){
        if(root == null) return 0;
        sum += root.val;
        int count = map.getOrDefault(sum - targetSum , 0);
        map.put(sum , map.getOrDefault(sum,0)+1);

        count += dfs(root.left,sum,targetSum,map);
        count += dfs(root.right,sum,targetSum,map);
        map.put(sum , map.getOrDefault(sum,0)-1);

        return count;
    }
}
