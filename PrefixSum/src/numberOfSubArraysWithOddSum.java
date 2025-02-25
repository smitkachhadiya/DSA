public class numberOfSubArraysWithOddSum {

    // 1524. Number of Sub-arrays With Odd Sum

    public static int numOfSubarrays(int[] arr) {
        int Mod = 1000000007;
        int oddCount = 0;
        int evenCount = 1;
        int total = 0;
        int prefixSum = 0;

        for (int ele : arr) {
            prefixSum += ele;
            if ((prefixSum & 1) == 1) {
                total = (total + evenCount) % Mod;
                oddCount++;
            } else {
                total = (total + oddCount) % Mod;
                evenCount++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(numOfSubarrays(arr));
    }
}
