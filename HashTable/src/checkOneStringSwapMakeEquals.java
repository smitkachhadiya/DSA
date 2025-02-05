import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkOneStringSwapMakeEquals {

    // 1790. Check if One String Swap Can Make Strings Equal

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndices.add(i);
            }
        }

        if (diffIndices.size() != 2) {
            return false;
        }
        int i = diffIndices.get(0);
        int j = diffIndices.get(1);

        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }

    public static boolean areAlmostEqual2(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1FrequencyMap = new char[26];
        char[] s2FrequencyMap = new char[26];
        int numDiffs = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if (s1Char != s2Char) {
                numDiffs++;
                if (numDiffs > 2) return false;
            }
            s1FrequencyMap[s1Char - 'a']++;
            s2FrequencyMap[s2Char - 'a']++;
        }
        return Arrays.equals(s1FrequencyMap, s2FrequencyMap);
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("aaa", "aac"));
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("abcd", "abdc"));
        System.out.println(areAlmostEqual("abcd", "acbd"));
    }
}
