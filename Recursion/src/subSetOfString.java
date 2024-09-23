import java.util.ArrayList;

public class subSetOfString {
    public static void main(String[] args) {
        String a = "abc";
        ArrayList<String> ans = new ArrayList<>();
        subSeq("" , a,ans);
        System.out.println(ans);
    }

    static void subSeq(String p , String up,ArrayList<String> ans){
        if(up.isEmpty()){
            //System.out.println(p);
            ans.add(p);

            return;
        }
        char ch = up.charAt(0);
        subSeq(p + ch,up.substring(1),ans);
        subSeq(p,up.substring(1),ans);
    }
}
