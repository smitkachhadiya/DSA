import java.util.ArrayList;
import java.util.List;

public class lexicographicalNumber {

    //  386. Lexicographical Numbers

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int count = 1;

        for(int i=0 ; i<n ; i++){
            ans.add(count);

            if(count*10 <= n){
                count = count * 10;
            }else{
                if(count >= n){
                    count = count / 10;
                }
                count++;
                while(count %10 == 0){
                    count /=10;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(15));
        System.out.println(lexicalOrder(13));
        System.out.println(lexicalOrder(100));
    }
}
