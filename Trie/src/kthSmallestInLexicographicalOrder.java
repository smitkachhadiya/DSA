public class kthSmallestInLexicographicalOrder {

    //  440. K-th Smallest in Lexicographical Order

    public static int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0){
            long steps = countSteps(n , curr , curr+1);
            if(steps <= k){
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private static long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n){
            steps += Math.min((long)n + 1 , next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(13,2));
        System.out.println(findKthNumber(1,1));
        System.out.println(findKthNumber(681692778,35125136));
        System.out.println(findKthNumber(681692778,351251360));
    }
}
