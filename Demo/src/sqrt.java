
import java.util.Scanner;

public class sqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double root = sc.nextInt();
        System.out.println(newtonSQRT(root));
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
}
