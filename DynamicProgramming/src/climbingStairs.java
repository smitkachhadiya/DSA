import java.util.HashMap;
import java.util.Map;

public class climbingStairs {

    //  76. Climbing Stairs

    public static int climbStairs(int n){
        Map<Integer,Integer> map = new HashMap<>();
        return climb(n,map);
    }

    public static int climb(int n,Map<Integer,Integer> map){
        if(n <= 1){
            return 1;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        int sum = climb(n - 1, map) + climb(n - 2, map);
        map.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
        System.out.println(climbStairs(5));
    }
}
