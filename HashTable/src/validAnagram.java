import java.util.HashMap;

public class validAnagram {

    // 242. Valid Anagram


    // method 1 : using Hashmap
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        for(char c : t.toCharArray()){
            if(!count.containsKey(c) || count.get(c) == 0){
                return false;
            }
            count.put(c , count.get(c) - 1);
        }
        return true;
    }

    // Method 2 :
    public static boolean isAnagram2(String s, String t) {
        int[] temp = new int[26];

        for(char c : s.toCharArray()){
            temp[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            temp[c - 'a']--;
        }

        for (int i : temp){
            if (i != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram","nagaram"));
        System.out.println(isAnagram2("rat","car"));
    }
}
