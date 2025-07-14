import java.util.ArrayList;
import java.util.List;

public class getEqualSubstringWithinBudget {

    //  1208. Get Equal Substrings Within Budget

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(), start = 0, end;
        for (end = 0; end < n; end++) {
            maxCost = maxCost - Math.abs(s.charAt(end) - t.charAt(end));
            if (maxCost < 0) {
                maxCost += Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
        }
        return end - start;
    }

    public static int equalSubstring2(String s, String t, int maxCost) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int curCost = 0, maxLength = 0, n = cs.length;
        for (int i = 0, j = -1; i < n; i++) {
            curCost += Math.abs(cs[i]-ct[i]);

            while (curCost > maxCost) {
                j++;
                curCost -= Math.abs(cs[j]-ct[j]);
            }

            maxLength = Math.max(maxLength, i-j);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd","bcdf",3));
        System.out.println(equalSubstring("abcd","cdef",3));
        System.out.println(equalSubstring("abcd","acde",0));
    }
}
