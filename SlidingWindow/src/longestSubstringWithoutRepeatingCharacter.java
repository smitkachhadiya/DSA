import java.util.HashMap;

public class longestSubstringWithoutRepeatingCharacter {

    //  3. Longest Substring Without Repeating Characters

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0, r=0, maxLen=0;
        int n = s.length();
        while(r<n)
        {
            if(map.containsKey(s.charAt(r)))
                l = Math.max(l,map.get(s.charAt(r))+1);

            int len = r-l+1;
            maxLen = Math.max(len,maxLen);
            map.put(s.charAt(r),r);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

}
