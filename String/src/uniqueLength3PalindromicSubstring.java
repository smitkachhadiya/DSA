package DSA.Astring;

import java.util.Arrays;
import java.util.HashSet;

public class uniqueLength3PalindromicSubstring {

    //  1930. Unique Length-3 Palindromic Subsequences

    public static int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        int res = 0;
        for (int c = 0; c < 26; c++) {
            int left = first[c];
            int right = last[c];
            if (right - left < 2) continue;

            boolean[] memo = new boolean[26];
            for (int i = left + 1; i < right; i++) {
                int idx = s.charAt(i) - 'a';
                if (!memo[idx]) {
                    memo[idx] = true;
                    res++;
                }
            }
        }
        return res;
    }

    //  Method 2

    public static int countPalindromicSubsequence2(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            int start = -1, end = -1;

            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == ch) {
                    if (start == -1) start = j;
                    end = j;
                }
            }

            if (start == -1 || start == end) continue;

            HashSet<Character> set = new HashSet<>();
            for (int j = start + 1; j < end; j++) {
                set.add(s.charAt(j));
            }
            ans += set.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
}
