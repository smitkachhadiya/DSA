import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {

    //  118. Pascal's Triangle

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int val = 1;
            for (int j = 1; j < i; j++) {
                val = val * (i - j);
                val /= j;
                temp.add(val);
            }
            ans.add(temp);
        }
        return ans;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            int n=1;
            for(int j=0;j<=i;j++){
                row.add(n);
                n=n*(i-j)/(j+1);
            }
            res.add(row);
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
