import java.util.Arrays;

public class constructLexicographicallyLargestValidSequence {

    //   1718. Construct the Lexicographically Largest Valid Sequence

    public static int[] constructDistancedSequence(int n) {
        int[] result = new int[2 *n-1];
        boolean[] usedNumbers = new boolean[n+1];
        construct(result,usedNumbers,0,n);
        return result;
    }

    private static boolean construct(int[] result , boolean[] usedNumber , int index , int n){
        if(index == result.length){
            return true;
        }

        if(result[index] != 0){
            return construct(result , usedNumber , index+1 ,n);
        }
        for (int i = n; i >= 1; i--) {
            if (usedNumber[i]){
                continue;
            }
            usedNumber[i] = true;
            result[index] = i;

            if(i == 1) {
                if( construct(result , usedNumber , index+1 , n)){
                    return true;
                }
            }else {
                if ( index+ i < result.length && result[index + i] == 0){
                    result[index+i] = i;
                    if (construct(result,usedNumber,index+1,n)){
                        return true;
                    }
                    result[index+i] = 0;
                }
            }
            usedNumber[i] = false;
            result[index] = 0;
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructDistancedSequence(3)));
        System.out.println(Arrays.toString(constructDistancedSequence(5)));
        System.out.println(Arrays.toString(constructDistancedSequence(7)));
    }
}
