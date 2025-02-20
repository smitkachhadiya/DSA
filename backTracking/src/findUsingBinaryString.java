import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findUsingBinaryString {
    
    // 1980. Find Unique Binary String

    // using Backtracking

    private String res;

    private boolean buildNumber(Set<String> numbers, String curr, int n) {
        if (curr.length() == n) {
            if (!numbers.contains(curr)) {
                res = curr;
                return true;
            }
            return false;
        }

        // Try '0'
        if (buildNumber(numbers, curr + '0', n)) {
            return true;
        }

        // Try '1'
        if (buildNumber(numbers, curr + '1', n)) {
            return true;
        }
        return false;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> numbers = new HashSet<>(Arrays.asList(nums));
        buildNumber(numbers, "", n);
        return res;
    }

    // Simple Implementation

    public static String findDifferentBinaryString2(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < nums.length ; i++){
            if(nums[i].charAt(i) == '0'){
                sb.append('1');
            }else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"01","10"};
        System.out.println(findDifferentBinaryString2(arr));
    }
}
