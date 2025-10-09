public class findTheMinAmountOfTimeToBrewPotions {

    //  3494. Find the Minimum Amount of Time to Brew Potions

    public static long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] done = new long[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                done[j+1] = Math.max(done[j+1],done[j]) + (long) mana[i] * skill[j];
            }
            for (int j = n-1; j >0 ; j--) {
                done[j] = done[j+1] - (long) mana[i] * skill[j];
            }
        }

        return done[n];
    }

    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1,5,2,4},new int[]{5,1,4,2}));
    }

}
