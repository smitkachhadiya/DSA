package DSA.Astring;

public class findTheKthCharInStringGame1 {

    //  3304. Find the K-th Character in String Game I

    public static char kthCharacter(int k) {
        String word = "a";
        return  helper(word,k);
    }

    public static char helper(String word,int k){
        if(word.length()>=k){
            return word.charAt(k-1);
        }
        int index=0;
        StringBuilder sb = new StringBuilder(word);
        while(index<word.length()){
            char ch = word.charAt(index);
            sb.append((char)(ch + 1));
            index++;
        }
        return helper(sb.toString(),k);
    }

    public static char kthCharacter2(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');

        while (sb.length() < k){
            StringBuilder temp = new StringBuilder();
            for (int i=0 ; i<sb.length() ; i++){
                char ch = (char) (sb.charAt(i)+1);
                temp.append(ch);
            }
            sb.append(temp);
        }
        System.out.println(sb.toString());
        return sb.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
        System.out.println(kthCharacter(10));
        System.out.println(kthCharacter(15));
        System.out.println(kthCharacter(100));
        System.out.println(kthCharacter(489));
    }

}
