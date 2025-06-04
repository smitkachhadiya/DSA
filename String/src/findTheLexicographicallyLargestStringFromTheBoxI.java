package DSA.Astring;

public class findTheLexicographicallyLargestStringFromTheBoxI {

    // 3403. Find the Lexicographically Largest String From the Box I

    public static String answerString(String word, int numFriends) {
        if(numFriends == 1){
            return word;
        }
        String ans = "";
        int length = word.length() - numFriends +1;

        for (int i = 0; i < word.length(); i++) {
            String temp;
            if(i + length <= word.length()){
                temp = word.substring(i,i + length);
            } else{
                temp = word.substring(i);
            }

            if(temp.compareTo(ans) > 0){
                ans = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(answerString("dbca",2));
        System.out.println(answerString("gggg",4));
    }
}
