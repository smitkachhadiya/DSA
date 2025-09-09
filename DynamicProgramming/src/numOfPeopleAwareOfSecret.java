import java.lang.reflect.Array;
import java.util.Arrays;

public class numOfPeopleAwareOfSecret {
    
    //  2327. Number of People Aware of a Secret

    static int MOD = 1000000007;
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int people = 0;
        int[] dp = new int[n+1];
        dp[1]=1;

        for (int i = 2; i < n+1; i++) {
            if(i-delay >= 1){
                people = (people + dp[i-delay]) % MOD ;
            }
            if(i-forget >= 1){
                people = (people - dp[i-forget]+ MOD) % MOD;
            }
            dp[i] =(int) people;
        }
        long ans =0;
        for (int i=n-forget+1;i < n+1;i++){
            if (i >= 1) {
                ans = (ans + dp[i]) % MOD;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6,2,4));
        System.out.println(peopleAwareOfSecret(4,1,3));
        System.out.println(peopleAwareOfSecret(50,5,10));
    }
}
