import java.util.HashMap;
import java.util.Map;

public class fibonacciNumber {

    //  509. Fibonacci Number

    // Using Recursion   -- works when n <= 30

    public static int fib1(int n) {
        if(n <= 1){
            return n;
        }
        return fib1(n-1) + fib1(n-2);
    }

    // Using DP

    public static int fib(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        return fibo(n , map);
    }

    public static int fibo(int n,Map<Integer,Integer> map) {
        if(n <= 1){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int c = fib(n - 1) + fib(n-2);
        return c;
    }

    // Method 2 --------------------------------------------

    public static int fib2(int n) {
        int n1=0, n2 = 1;
        if(n==0) {
            return n1;
        }
        if(n==1) {
            return 1;
        }
        int fib =0;
        for(int i=1;i<n; i++ ){
            fib = n1 + n2;
            n1 = n2;
            n2 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(10));
        System.out.println(fib(30));
    }
}
