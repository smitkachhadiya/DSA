package DSA.Astring;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInArray {

    // 1408. String Matching in an Array

    public static List<String> stringMatching(String[] words) {
        List ans = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // if(i!=j && words[j].indexOf(words[i])!=-1)
                if(i != j && words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String word[] = {"mass","as","hero","superhero"};
        System.out.println(stringMatching(word));
    }
}
