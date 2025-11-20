public class keepMultiplyingFoundValueByTwo {

    //  2154. Keep Multiplying Found Values by Two

    public static int findFinalValue(int[] nums, int original) {
        boolean[] memo = new boolean[1001];
        for (int x : nums) {
            if (x <= 1000) memo[x] = true;
        }
        int ans = original;
        while (ans <= 1000) {
            if (memo[ans]) ans *= 2;
            else break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{5,3,6,1,12},3));
    }
}
