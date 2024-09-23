package DSA.src;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        setPermutation("","abc",ans);
        System.out.println(ans);
    }

    static void setPermutation(String p , String up,ArrayList<String> ans){
        if(up.isEmpty()){
            //System.out.println(p);
            ans.add(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i=0 ; i <= p.length() ; i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            setPermutation(first + ch + second,up.substring(1),ans);
        }
    }
}
