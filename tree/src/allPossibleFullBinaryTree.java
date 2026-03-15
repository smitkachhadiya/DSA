import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allPossibleFullBinaryTree {

    //  894. All Possible Full Binary Trees

    static Map<Integer, List<TreeNode>> ans = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n%2==0)
            return new ArrayList<>();

        if (!ans.containsKey(n)) {
            List<TreeNode> list = new ArrayList<>();

            if (n==1)
                list.add(new TreeNode(0));
            else {
                for (int i=1; i<=n-1; i+=2) {
                    List<TreeNode> lTrees = allPossibleFBT(i);
                    List<TreeNode> rTrees = allPossibleFBT(n-i-1);

                    for (TreeNode lt: lTrees) {
                        for (TreeNode rt: rTrees) {
                            list.add(new TreeNode(0, lt, rt));
                        }
                    }
                }
            }

            ans.put(n, list);
        }
        return ans.get(n);
    }

    public static void main(String[] args) {
        allPossibleFullBinaryTree bt = new allPossibleFullBinaryTree();
        System.out.println(bt.allPossibleFBT(7));
        System.out.println(bt.allPossibleFBT(3));
    }
}
