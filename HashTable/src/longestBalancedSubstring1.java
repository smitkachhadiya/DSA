public class longestBalancedSubstring1 {

    //  3713. Longest Balanced Substring I

    public static int longestBalanced(String s) {
        char[] array = s.toCharArray();
        int[] freq = null;
        int n = array.length;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            freq = new int[128];
            int distinct = 0;
            int maxFreq = 1;
            for (int j = i; j < n; j++) {
                freq[array[j]]++;
                if (freq[array[j]] == 1) {
                    distinct++;
                }
                maxFreq = Math.max(maxFreq, freq[array[j]]);
                if ((j - i + 1) == maxFreq * distinct) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
        System.out.println(longestBalanced("abbazzc"));
        System.out.println(longestBalanced("aba"));
    }
}
