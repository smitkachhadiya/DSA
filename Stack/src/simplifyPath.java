package DSA.dataSets.stack;

import java.util.Stack;

public class simplifyPath {

    // 71. Simplify Path
    public static String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String element : arr){
            if(element.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!element.equals(".") && !element.isEmpty()){
                stack.push(element);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(String element : stack){
            ans.append("/").append(element);
        }
        return ans.length() > 0 ? ans.toString() : "/" ;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }
}
