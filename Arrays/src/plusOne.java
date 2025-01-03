import java.util.Arrays;

// 66. Plus One
public class plusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1; i >= 0 ; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] ans = new int[len+1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        System.out.println(Arrays.toString(plusOne(a)));

    }
}
