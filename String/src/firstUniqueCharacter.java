package DSA.Astring;

public class firstUniqueCharacter {

    // 387. First Unique Character in a String

    public int firstUniqChar(String s) {
        for (char ch : s.toCharArray()){
            if(s.indexOf(ch) == s.lastIndexOf(ch)){
                return s.indexOf(ch);
            }
        }
        return -1;
    }


    // Method : 2
    public int firstUniqChar2(String s) {
        if(s.length() == 0) return -1;
        int[] store = new int[26];
        for(char ch : s.toCharArray()){
            store[ch - 'a']++;
        }
        for(int idx = 0; idx < s.length(); idx++){
            if(store[s.charAt(idx) - 'a'] == 1){
                return idx;
            }
        }
        return -1;
    }
}
