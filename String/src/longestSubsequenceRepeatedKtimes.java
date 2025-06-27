package DSA.Astring;

import java.util.LinkedList;
import java.util.Queue;

public class longestSubsequenceRepeatedKtimes {

    //  2014. Longest Subsequence Repeated k Times

    public static String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; ++i) {
            freq[s.charAt(i)-'a']++;
        }

        String curr  = "";
        Queue<String> queue = new LinkedList<>();
        queue.offer(curr);
        String ans = "";

        while (!queue.isEmpty()){
            curr = queue.poll();

            for (char c = 'a' ; c <= 'z' ; ++c){
                if(freq[c - 'a'] < k){
                    continue;
                }
                String seq = curr + c;
                if(countSubSequence(s,seq) >= k){
//                    System.out.print(seq + " ");
                    ans = seq;
                    queue.offer(seq);
                }
            }
        }

        return ans;
    }

    public static int countSubSequence(String s , String seq){
        int i = 0 , j = 0;
        int n = seq.length();
        int count = 0;

        while (i < s.length()){
            if(s.charAt(i) == seq.charAt(j)){
                j++;
                if(j == n){
                    count++;
                    j = 0;
                }
            }
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequenceRepeatedK("letsleetcode",2));
        System.out.println(longestSubsequenceRepeatedK("bb",2));
        System.out.println(longestSubsequenceRepeatedK("ab",2));

//        System.out.println(countSubSequence("letsleetcode","let"));
    }

}
