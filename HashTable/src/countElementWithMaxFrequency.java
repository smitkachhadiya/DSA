public class countElementWithMaxFrequency {

    //  3005. Count Elements With Maximum Frequency

    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for(int i : nums){
            freq[i]++;
            if(freq[i] > max){
                max = freq[i];
            }
        }
        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] == max){
                count += max;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,3,4,5}));
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
    }
}
