import java.util.HashMap;

public class MaxDifferenceBetweenEvenAndOddFrequencyI {

    //  3442. Maximum Difference Between Even and Odd Frequency I

    public static int maxDifference(String s) {
        int[] freq = new int[26];
        int max = 0;
        int min = s.length();
        for (char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for (int i = 0 ; i < 26 ; i++){
            if(freq[i] % 2 != 0){
                max = Math.max(max,freq[i]);
            }
            if(freq[i] % 2 == 0 && freq[i] > 0){
                min = Math.min(min,freq[i]);
            }
        }

        return max-min;
    }

    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
        System.out.println(maxDifference("abcabcab"));
    }
}
