import java.util.ArrayList;
import java.util.List;

public class longestUnequalAdjacentGroupsSubsequenceI {

    // 2900. Longest Unequal Adjacent Groups Subsequence I

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int order = -1;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != order) {
                order = groups[i];
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","c","d","e","f","g"};
        int[] group = {1,0,1,1,0,2,2};
        System.out.println(getLongestSubsequence(words,group));
    }

}
