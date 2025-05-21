public class threeConsecutiveOdds {

    // 1550. Three Consecutive Odds

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n : arr){
            if((n & 1) == 1){
                count++;
                if (count == 3){
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean threeConsecutiveOdds2(int[] arr) {
        if (arr.length < 3) return false;
        for (int i = 0; i <= arr.length - 3; i++) {
            if ((arr[i] & 1) == 1 && (arr[i+1] & 1) == 1 && (arr[i+2] & 1) == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,4,1};
        int[] arr1 = {1,2,34,3,4,5,7,23,12};
        System.out.println(threeConsecutiveOdds(arr));
        System.out.println(threeConsecutiveOdds2(arr1));
    }
}
