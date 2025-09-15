package DSA.Astring;

public class maxNumOfWordsYouCanType {

    //  1935. Maximum Number of Words You Can Type

    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int count = 0;
        for(String word : words){
            boolean isPossible = true;
            for(char ch : brokenLetters.toCharArray()){
                if(word.indexOf(ch) != -1){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world","ad"));
    }
}
