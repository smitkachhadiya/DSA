package DSA.Astring;

public class maxScoreAfterSplittingString {

    // 1422. Maximum Score After Splitting a String

    public static int maxScore(String s) {
        int diff = 0;
        int maxDiff = -1;
        int oneCount = 0;
        int last = s.length() - 1;
        for(int i = 0; i < last; i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
                diff--;
            }
            else
                diff++;
            if (diff > maxDiff)
                maxDiff = diff;
        }
        if (s.charAt(last) == '1')
            oneCount++;
        return oneCount + maxDiff;
    }

    // method 2 :

    public static int maxScore2(String s) {
        int ans = 0;
        int temp[] = new int[s.length()];
        for(int i=1; i< s.length() ; i++){
            System.out.println(s.substring(0,i) + " " + s.substring(i));
            temp[i] = countZero(s.substring(0,i)) + countOne(s.substring(i));
        }

         for(int i : temp){
            if(i > ans){
                ans = i;
            }
        }
        return ans;
    }

    public static int countZero(String s){
        int n=0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                n++;
            }
        }
        return n;
    }

    public static int countOne(String s){
        int n=0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("010110"));
    }
}
