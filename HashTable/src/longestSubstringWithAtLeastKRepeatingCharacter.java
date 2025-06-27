import java.util.Arrays;

public class longestSubstringWithAtLeastKRepeatingCharacter {

    //  395. Longest Substring with At Least K Repeating Characters

    // Using Divide And Conquer Approach

    public static int longestSubstring(String s, int k) {
//        return longestSubstring(s,k,0,s.length());
        return longestSubstring(s,k,0,s.length());
    }

    private static int longestSubstring(String s, int k, int start, int end) {
        if (end - start < k) {
            return 0;
        }


        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }


        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;

                while (j < end && count[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(longestSubstring(s, k, start, i), longestSubstring(s, k, j, end));
            }
        }

        return end - start;
    }

    public static int longestSubstring2(String s,int k, int start , int end) {
        if(end - start < k){
            return 0;
        }
        
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(freq));

        for (int i = start; i < end; i++) {
            if(freq[s.charAt(i) - 'a'] < k){
                int left = longestSubstring(s,k,start,i);
                int right = longestSubstring(s,k,i+1,end);
                return Math.max(left,right);
            }
        }

        return end-start;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb",3));
        System.out.println(longestSubstring("ababbc",2));
        System.out.println(longestSubstring("ababacb",3));
    }
}
