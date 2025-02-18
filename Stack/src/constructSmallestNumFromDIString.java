package DSA.dataSets.stack;

import java.util.Stack;

public class constructSmallestNumFromDIString {

    //  2375. Construct Smallest Number From DI String

    public static String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder(pattern.length());
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(num++);

            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while (!stack.isEmpty()){
                    ans.append(stack.pop());
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
        System.out.println(smallestNumber("IIIDIDDDI"));
    }
}
