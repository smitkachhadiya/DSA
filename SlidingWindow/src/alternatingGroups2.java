public class alternatingGroups2 {
    
    //  3208. Alternating Groups II

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int l = 0;
        int limit = n + k - 1;

        while (l < n) {
            int r = l + 1;
            while (r < limit && colors[(r - 1) % n] != colors[r % n]) {
                r++;
            }

            if (r - l >= k) {
                count += (r - l) - k + 1;
            }
            l = r;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1,0} ,3));
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1} ,6));
    }
}
