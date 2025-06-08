public class countNumberOfComputerUnlockingPermutations {

    //  3577. Count the Number of Computer Unlocking Permutations

    // Weekly Contest 453

    public static int countPermutations(int[] complexity) {
        int MOD = 1000000007;
        int n = complexity.length;
        int min = Integer.MAX_VALUE;
        for(int i : complexity){
            min = Math.min(min,i);
        }

        if(complexity[0] != min){
            return 0;
        }

        int count = 0;

        for(int i : complexity){
            if(i == min){
                count++;
            }
            if(count > 1){
                return 0;
            }
        }

        long ans = 1;
        for(int i = 1 ; i < n ; i++){
            ans = (ans * i) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countPermutations(new int[]{1,2,3}));
        System.out.println(countPermutations(new int[]{3,3,3,4,4,4}));
    }
}
