public class findTheKthCharInStringGame2 {

    //  3307. Find the K-th Character in String Game II

    //  Using Bit Manipulation3307. Find the K-th Character in String Game II
    public static char kthCharacter(long k, int[] operations) {
        k -= 1;
        int res = 0;
        for (int i = 0; i < operations.length && i < 60; ++i) {
            if (((k >> i) & 1) == 1) {
                res += operations[i];
            }
        }
        return (char)('a' + res % 26);
    }

    //  Method 2 :

    public static char kthCharacter2(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;

        for (int i = 1; i <= n; i++) {
            lengths[i] = lengths[i - 1] * 2;
            if (lengths[i] >= k) {
                lengths[i] = k;
            }
        }

        char curr = 'a';
        for (int i = n; i > 0; i--) {
            long half = lengths[i - 1];

            if (k > half) {
                k -= half;
                if (operations[i - 1] == 1) {
                    curr = (char) ((curr - 'a' + 1) % 26 + 'a');
                }
            }
        }
        return curr;
    }

    // got TLE ---------------------------------------------------------------------------------
    public static char kthCharacter3(long k, int[] operations) {
        StringBuilder sb = new StringBuilder("a");
        for (int i : operations){
            int len = sb.length();
            if(i == 0){
                sb.append(sb);
            } else {
                int index=0;
                while(index < len){
                    char ch = (char)((sb.charAt(index) - 'a') % 26 + 'a');
                    sb.append(ch);
                    index++;
                }
            }

            if(sb.length() >= k){
                break;
            }
        }

        return sb.charAt((int) k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5,new int[]{0,0,0}));
        System.out.println(kthCharacter(10,new int[]{0,1,0,1}));
    }
}
