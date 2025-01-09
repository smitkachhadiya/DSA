package DSA.Astring;

public class countingWordWithGivenPrefix {

    // 2185. Counting Words With a Given Prefix

    public static int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(int i=0 ; i < words.length ; i++){
            if(words[i].startsWith(pref)){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] word = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(prefixCount(word,pref));
    }
}
