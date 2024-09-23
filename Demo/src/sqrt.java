package DSA.src;

import java.util.Scanner;

public class sqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double root = sc.nextInt();
        System.out.println(newtonSQRT(root));
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
