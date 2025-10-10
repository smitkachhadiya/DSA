public class takingMaxEnergyFromTheMysticDungeon {

    //  3147. Taking Maximum Energy From the Mystic Dungeon

    public static int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        for (int i=energy.length-k;i<energy.length;i++) {
            max = Math.max(max, energy[i]);
        }

        for (int i=energy.length-k-1;i>=0;i--) {
            energy[i] += energy[i+k];
            max = Math.max(max, energy[i]);
        }
        return max;
    }

    public static int maximumEnergy2(int[] energy, int k) {
        int l = energy.length;
        int[] dp = new int[l];
        int result = Integer.MIN_VALUE;
        for (int i = l - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < l ? dp[i + k] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumEnergy(new int[]{5,2,-10,-5,1},3));
    }
}
