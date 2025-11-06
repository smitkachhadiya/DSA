import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class mostFrequentSubtreeSum {

    //  508. Most Frequent Subtree Sum

    Map<Integer,Integer> map = new HashMap<>();
    int mostFreq = 0;
    List<Integer> maxSumArr = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);

        int[] arr = new int[maxSumArr.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = maxSumArr.get(i);
        }
        return arr;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int sum = root.val + helper(root.left) + helper(root.right);
        map.put(sum , map.getOrDefault(sum, 0) + 1);

        if(map.get(sum) > mostFreq){
            maxSumArr.clear();
            maxSumArr.add(sum);
            mostFreq = map.get(sum);
        }else if(map.get(sum) == mostFreq){
            maxSumArr.add(sum);
        }

        return sum;
    }

    // Method 2:
    public int[] findFrequentTreeSum2(TreeNode root) {
        postorder(root);

        ArrayList<Integer> temp = new ArrayList();
        for(int i : map.keySet()){
            if(map.get(i) == mostFreq)temp.add(i);
        }

        int []res = new int[temp.size()];
        for(int i = 0;i< temp.size();i++){
            res[i] = temp.get(i);
        }
        return res;
    }

    public int postorder(TreeNode root){
        if(root == null)return 0;

        int left = postorder(root.left);
        int right = postorder(root.right);
        int sum = left + right + root.val;

        map.put(sum,map.getOrDefault(sum,0) + 1);
        mostFreq = Math.max(mostFreq,map.get(sum));

        return sum;
    }


}
