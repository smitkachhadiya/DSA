public class totalCharacterInStringAfterTransactionI {

    // 3335. Total Characters in String After Transformations I

    private static final int M = 1_000_000_007;

    public static int lengthAfterTransformations(String s, int t) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()){
            map[ch - 'a']++;
        }

        for (int n = 0; n < t; n++) {
            int[] temp = new int[26];

            for (int i = 0; i < 26; i++) {
                char ch = (char)(i+'a');
                int freq = map[i];

                if(ch != 'z'){
                    temp[(ch + 1)-'a'] = (temp[(ch + 1)-'a'] + freq) ;
                } else {
                    temp['a' - 'a'] = (temp['a' - 'a'] + freq) % M;
                    temp['b' - 'a'] = (temp['b' - 'a'] + freq) % M;
                }
            }
            map = temp;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + map[i]) % M;
        }
        return ans;
    }

    public static void main(String[] args) {
        String sc = "abcyy";
        int t = 2;
        System.out.println(lengthAfterTransformations(sc,t));
    }
}
