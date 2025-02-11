package DSA.Astring;

import java.util.Stack;

public class removeAllAccurenceOfSubstring {

    // 1910. Remove All Occurrences of a Substring

    public static String removeOccurrences(String s, String part) {
        while (s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        return s;
    }

    // --------------------------  Implementation using stack  -------------------------

    public static String removeOccurrences2(String s, String part) {
        Stack<Character> stack = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        for (int index = 0; index < strLength; index++) {
            stack.push(s.charAt(index));

            if(stack.size() >= partLength && check(stack,part,partLength)){
                for(int j=0; j < partLength ; j++){
                    stack.pop();
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        ans.reverse();

        return ans.toString();
    }

    public static boolean check(Stack<Character> stack , String part , int partLength){
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);

        for (int i = partLength-1; i >= 0; i--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)){
                return false;
            }
            temp.pop();
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(removeOccurrences2("daabcbaabcbc","abc"));
        System.out.println(removeOccurrences2("axxxxyyyyb","xy"));
        System.out.println(removeOccurrences2("aabababa","aba"));
    }
}
