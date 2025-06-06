package DSA.dataSets.stack;

import java.util.Stack;

public class usingRobotToPrintLexicographicallySmallestString {

    //  2434. Using a Robot to Print the Lexicographically Smallest String

    public static String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for (char ch : s.toCharArray()){
            stack.push(ch);
            freq[ch - 'a']--;

            while (!stack.isEmpty() && stack.peek() <= findSmallest(freq)){
                sb.append(stack.pop());
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static char findSmallest(int[] freq){
        for (int i = 0; i < 26; i++) {
            if(freq[i] > 0){
                return (char) ('a'+i);
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        System.out.println(robotWithString("zza"));
        System.out.println(robotWithString("bac"));
        System.out.println(robotWithString("bdda"));
    }
}
