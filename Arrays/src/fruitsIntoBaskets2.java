public class fruitsIntoBaskets2 {

    //  3477. Fruits Into Baskets II

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length,alloted=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(fruits[i]<=baskets[j])
                {
                    alloted++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return n - alloted;
    }

    public static int numOfUnplacedFruits2(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        return unplaced;
    }

    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4,2,5},new int[]{3,2,5}));
    }
}
