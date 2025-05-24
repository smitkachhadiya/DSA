package DSA.Astring;

import java.util.ArrayList;
import java.util.List;

public class findWordContainingCharacter {

    //  2942. Find Words Containing Character

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].indexOf(x) != -1){
                ans.add(i);
            }
        }

        return ans;
    }

    public static List<Integer> findWordsContaining2(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].contains(x+"")){
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc","bcd","aaaa","cbc"};
        char x = 'a';
        System.out.println(findWordsContaining(words,x));
    }

}
