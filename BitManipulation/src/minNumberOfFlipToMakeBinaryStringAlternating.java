public class minNumberOfFlipToMakeBinaryStringAlternating {

    //  1888. Minimum Number of Flips to Make the Binary String Alternating

    public static int minFlips(String s) {
        int n = s.length();
        int cost1 = 0;
        int cost2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') cost1++;
                else
                    cost2++;
            } else {
                if (s.charAt(i) == '0') cost1++;
                else
                    cost2++;
            }
        }

        int result = Math.min(cost1, cost2);
        if (n % 2 == 1) {
            String doubled = s + s;
            for (int i = 1; i < n; i++) {
                char leaving = doubled.charAt(i - 1);
                char entering = doubled.charAt(i + n - 1);

                if ((i - 1) % 2 == 0) {
                    if (leaving == '1') cost1--;
                    else
                        cost2--;
                } else {
                    if (leaving == '0') cost1--;
                    else
                        cost2--;
                }

                if ((i + n - 1) % 2 == 0) {
                    if (entering == '1') cost1++;
                    else
                        cost2++;
                } else {
                    if (entering == '0') cost1++;
                    else
                        cost2++;
                }
                result = Math.min(result, Math.min(cost1, cost2));
            }
        }
        return result;
    }

    //  Brute Force

    public static int minFlips2(String s) {
        int n = s.length();
        String t = s + s;

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            char expect1 = (i % 2 == 0) ? '0' : '1';
            char expect2 = (i % 2 == 0) ? '1' : '0';

            if (t.charAt(i) != expect1) diff1++;
            if (t.charAt(i) != expect2) diff2++;

            if (i >= n) {
                char oldExpect1 = ((i - n) % 2 == 0) ? '0' : '1';
                char oldExpect2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (t.charAt(i - n) != oldExpect1) diff1--;
                if (t.charAt(i - n) != oldExpect2) diff2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("111000"));
        System.out.println(minFlips("101010"));
        System.out.println(minFlips("1110"));
    }
}
