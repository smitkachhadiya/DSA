package DSA.Astring;

public class clearDigit {

    // 3174. Clear Digits

    public static String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()){
            if(Character.isDigit(c)){
                if(ans.length() > 0){
                    ans.deleteCharAt(ans.length() - 1);
                }
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
        System.out.println(clearDigits("1df56tgf2l"));
    }
}
