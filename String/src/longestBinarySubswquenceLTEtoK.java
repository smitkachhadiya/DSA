package DSA.Astring;

public class longestBinarySubswquenceLTEtoK {

    //  2311. Longest Binary Subsequence Less Than or Equal to K

    public static int longestSubsequence(String s, int k) {
        int n = s.length();
        int i = 0;
        long sum = 0;

        while(i < n){
            if(s.charAt(n - i - 1) == '1'){
                long power = (long) Math.pow(2,i);
                if(sum + power > k){
                    break;
                }
                sum += power;
            }
            i++;
        }

        int removed = 0;
        while (i < n){
            if(s.charAt(n - i - 1) == '1'){
                removed++;
            }
            i++;
        }

        return n - removed;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010",5));
        System.out.println(longestSubsequence("00101001",1));
    }
}
