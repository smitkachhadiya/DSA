import java.util.Arrays;

public class findPrefixCommonArrayOfTwoArray {

    // 2657. Find the Prefix Common Array of Two Arrays

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        boolean[] checked = new boolean[n+1];
        int common = 0;
        for (int i = 0; i < n; i++) {
            if(checked[A[i]]){
                common++;
            }else {
                checked[A[i]] = true;
            }

            if(checked[B[i]]){
                common++;
            }else {
                checked[B[i]] = true;
            }

            ans[i] = common;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        int[] result1 = findThePrefixCommonArray(A1, B1);
        System.out.println(Arrays.toString(result1));
    }
}
