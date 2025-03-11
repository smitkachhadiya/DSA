public class numOfSubstringContainingAllThreeCharacter {

    //  1358. Number of Substrings Containing All Three Characters

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[] freq = new int[3];

        int left = 0, right = 0;
        while (right < n) {
            freq[s.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += n - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
