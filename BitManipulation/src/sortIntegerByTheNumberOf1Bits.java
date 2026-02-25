import java.util.Arrays;

public class sortIntegerByTheNumberOf1Bits {

    //  1356. Sort Integers by The Number of 1 Bits

    public static int[] sortByBits(int[] arr) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp,(a,b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if(countA == countB) return a - b;
            return countA - countB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(sortByBits(new int[]{0,1,2,3,4,5,6,7,8}));
    }
}
