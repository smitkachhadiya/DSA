public class minimumWindowSubstring {

    //  76. Minimum Window Substring

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] tArray = new int[128];
        for (char ch : t.toCharArray()) {
            tArray[ch]++;
        }

        int[] sArray = new int[128];
        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            sArray[rChar]++;

            if (tArray[rChar] > 0 && sArray[rChar] <= tArray[rChar]) {
                required--;
            }

            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                sArray[lChar]--;
                if (tArray[lChar] > 0 && sArray[lChar] < tArray[lChar]) {
                    required++;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minWindow("a","a"));
        System.out.println(minWindow("ADOBECODEBANC","ABBC"));
    }

}
