
import java.util.Scanner;

public class sqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int root = sc.nextInt();
        System.out.println(sqrtBinarySearch(root));
    }

    // 69. sqrt(x)
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    static double newtonSQRT(double n){
        double root;
        double x=n;

        while (true){
            root = 0.5 * (x + (n/x));

            if(Math.abs(root - x) <= 0){
                break;
            }

            x = root;
        }

        return root;
    }

    static int sqrtBinarySearch(int n){
        int start=0,end=n;
        int ans=0;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if(mid*mid == n){
                return mid;
            } else if(mid*mid < n){
                start = mid+1;
                ans = mid;
            }else {
                end = mid-1;
            }

        }
        return ans;
    }
}
