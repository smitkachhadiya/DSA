public class neighboringBitwiseXOR {

    public static boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int n : derived) {
            xorSum ^= n;
        }
        return xorSum == 0;
    }

    // Method 2 :
    public boolean doesValidArrayExist2(int[] derived) {
        return isPossibleWithStart(derived,0)||isPossibleWithStart(derived,1);
    }

    boolean isPossibleWithStart(int derived[],int start){
        int n=derived.length,curr=start;
        for(int i=0;i<n;i++){
            curr=curr^derived[i];
        }
        return curr==start;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,0,1};
        System.out.println(doesValidArrayExist(arr));
    }
}
