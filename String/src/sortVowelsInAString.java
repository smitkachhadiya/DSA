package DSA.Astring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortVowelsInAString {

    //  2785. Sort Vowels in a String

    public static String sortVowels(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ("aeiou".indexOf(c) != -1) {
                lower[c - 'a']++;
                chars[i] = '#';
            } else if ("AEIOU".indexOf(c) != -1) {
                upper[c - 'A']++;
                chars[i] = '#';
            }
        }

        StringBuilder sortedVowels = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            while (upper[i] > 0) {
                sortedVowels.append(c);
                upper[i]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (lower[i] > 0) {
                sortedVowels.append(c);
                lower[i]--;
            }
        }

        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                chars[i] = sortedVowels.charAt(j++);
            }
        }

        return new String(chars);
    }

    // Method 2 :

    public static String sortVowels2(String s) {
        List<Character> vowel = new ArrayList<>();
        for (char c : s.toCharArray()){
            if("aeiouAEIOU".indexOf(c) != -1){
                vowel.add(c);
            }
        }
        Collections.sort(vowel);
        int index = 0;
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            if("aeiouAEIOU".indexOf(c) != -1){
                ans.append(vowel.get(index++));
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("lYmpH"));
    }
}
