package DSA.Astring;

import java.util.HashMap;

public class constructKPalindromeString {

    // 1400. Construct K Palindrome Strings

    public static boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        if (s.length() == k) return true;

        int[] freq = new int[26];
        int oddCount = 0;

        for (char chr : s.toCharArray()) {
            freq[chr - 'a']++;
        }

        for (int count : freq) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }

    // Method : 2
    public static boolean canConstruct2(String s, int k) {
        if(k > s.length()){
            return false;
        }

        HashMap<Character , Integer> count = new HashMap<>();
        for (char c : s.toCharArray()){
            count.put(c , count.getOrDefault(c,0) + 1);
        }

        int odd = 0;
        for(int n : count.values()){
            if(n % 2 != 0){
                odd++;
            }
        }

        return odd <= k;

    }

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
        System.out.println(canConstruct("leetcode" , 3));
    }
}
