public class findMostFreqVowelAndConsonant {

    //  3541. Find Most Frequent Vowel and Consonant

    public static int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0 , maxConsonant = 0;
        for(char ch : s.toCharArray()){
            int i = 'a' - ch;
            freq[i]++;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                maxVowel = Math.max(maxVowel,freq[i]);
            }else{
                maxConsonant = Math.max(maxConsonant,freq[i]);
            }
        }
        return maxConsonant+maxVowel;
    }

    public static void main(String[] args) {
        System.out.println(maxFreqSum("aeiaeia"));
        System.out.println(maxFreqSum("successes"));
    }
}
