import java.util.Arrays;

public class successfulPairsOfSpellsAndPotions {

    //  2300. Successful Pairs of Spells and Potions

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for(int k= 0; k < spells.length; k++) {
            int spell = spells[k];
            int i = 0;
            int j = potions.length;
            while (i < j) {
                int mid = (i + j) / 2;
                if ((long) potions[mid] * spell >= success) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
            res[k] = potions.length - i;
        }
        return res;
    }

    public static int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] total = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int sum = numPotions(spells[i],potions,success);
            if (sum != -1) {
                total[i] = potions.length - sum;
            }
        }
        return total;
    }

    private static int numPotions(long spell, int[] potions, long success) {
        int low = 0, high = potions.length - 1, idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) potions[mid] * spell >= success) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(successfulPairs(new int[]{5,1,3},new int[]{2,1,3,4,5},7));
    }
}
