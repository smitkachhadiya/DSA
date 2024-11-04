package DSA.Astring;

import javax.print.DocFlavor;

public class fancyString {

    // 1957. Delete Character To Make Fancy String
    public static String makeFancyString(String s) {
        StringBuilder sc = new StringBuilder();
        sc.append(s.charAt(0));
        int count = 1;

        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }else{
                count = 1;
            }

            if(count  < 3 ){
                sc.append(s.charAt(i));
            }
        }
        return sc.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));
        System.out.println(makeFancyString("aaabaaaa"));
    }
}
