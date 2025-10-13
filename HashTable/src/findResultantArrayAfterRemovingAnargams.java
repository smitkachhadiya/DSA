import java.util.*;

public class findResultantArrayAfterRemovingAnargams {

    //  2273. Find Resultant Array After Removing Anagrams

    public static List<String> removeAnagrams(String[] words) {
        List<String> list= new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<words.length;i++){

            if(!isAnagram(words[i],words[i-1])){
                list.add(words[i]);
            }
        }
        return list;
    }

    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[]count= new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c:count){
            if(c!=0){
                return false;
            }
        }
        return true;
    }

    //  Using Sorting

    public static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public List<String> removeAnagrams2(String[] words) {
        String prev="";
        List<String>ans=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            String str=sortString(words[i]);
            if(!str.equals(prev))
            {
                prev=str;
                ans.add(words[i]);
            }
        }
        return ans;
    }

    // Using HashMap

    public static List<String> removeAnagrams3(String[] words) {
        int n = words.length;
        List<Map<Character,Integer>> map = new ArrayList<>();
        for (String s : words){
            Map<Character,Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()){
                freq.put(c,freq.getOrDefault(c,0)+1);
            }
            map.add(freq);
        }
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < n; i++) {
            if(!map.get(i).equals(map.get(i-1))){
                ans.add(words[i]);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
        System.out.println(removeAnagrams(new String[]{"a","b","c","d","e"}));
    }

}
