package DSA.Astring;

import java.util.ArrayList;
import java.util.Arrays;

public class keyboardRow {

    //  500. Keyboard Row

    public static String[] findWords(String[] words) {
        ArrayList<String> ans=new ArrayList<>();
        String first = "qwertyuiop";
        String Secound ="asdfghjkl";
        String Third="zxcvbnm";
        for(String i : words){
            if(isinrow(i,first) || isinrow(i,Secound) || isinrow(i,Third))
                ans.add(i);
        }
        return ans.toArray(new String[0]);
    }

    private static boolean isinrow(String s,String row){
        for(char c:s.toCharArray()){
            if(row.indexOf(Character.toLowerCase(c))==-1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(findWords(new String[]{"adsdf", "sfd"})));
    }
}
