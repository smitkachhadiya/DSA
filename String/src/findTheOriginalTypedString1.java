package DSA.Astring;

public class findTheOriginalTypedString1 {

    //  3330. Find the Original Typed String I

    public static int possibleStringCount(String word) {
        int count = 0;

        for(int i=0 ; i < word.length()-1; i++){
            if(word.charAt(i) == word.charAt(i+1)){
                count++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        System.out.println(possibleStringCount("abcd"));
        System.out.println(possibleStringCount("aaaa"));
    }
}
