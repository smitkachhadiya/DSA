

public class removeFromString {
    public static void main(String[] args) {
        String s = "abcasdqad";
//        System.out.println(s.substring(1));
        String a = remove("",s);
        System.out.println(a);
    }

    public static String remove(String ans,String remaining){
        if(remaining.isEmpty()){
            return ans;
        }
        char ch = remaining.charAt(0);
        if(ch == 'a'){
            return remove(ans,remaining.substring(1));
        }else {
            return remove(ans + ch,remaining.substring(1));
        }

    }
}
