import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class finding3DigitEvenNumber {

    // 2094. Finding 3-Digit Even Numbers

    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> ans = new ArrayList();
        int[] freq = new int[10];

        for (int digit : digits){
            freq[digit]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0){
                continue;
            }
            freq[i]--;

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0){
                    continue;
                }
                freq[j]--;

                for (int k = 0; k <= 8; k+=2) {
                    if (freq[k] == 0){
                        continue;
                    }
                    freq[k]--;

                    int num = (i*100) + (j*10) + k;
                    ans.add(num);

                    freq[k]++;
                }
                freq[j]++;
            }
            freq[i]++;
        }

        Collections.sort(ans);
        int[] result = new int[ans.size()];
        for (int i=0 ; i < ans.size() ; i++){
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,0};
        System.out.println(Arrays.toString(findEvenNumbers(arr)));
    }

}
