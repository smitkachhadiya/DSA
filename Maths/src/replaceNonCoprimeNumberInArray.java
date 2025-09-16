import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class replaceNonCoprimeNumberInArray {

    // 2197. Replace Non-Coprime Numbers in Array

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> s = new Stack<>();
        s.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            while (!s.isEmpty() && gcd(s.peek(), curr) > 1) {
                int top = s.pop();
                curr = lcm(top, curr);
            }
            s.push(curr);
        }

        return new ArrayList<>(s);
    }

    public static int gcd(int a,int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        System.out.println(replaceNonCoprimes(new int[]{6,4,3,2,7,6,2}));
        System.out.println(replaceNonCoprimes(new int[]{2,2,1,1,3,3,3}));
    }
}
