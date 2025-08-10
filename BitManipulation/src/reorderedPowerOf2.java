import java.util.Arrays;

public class reorderedPowerOf2 {

    //  869. Reordered Power of 2

    public static boolean reorderedPowerOf2(int n) {
        String target = sortedString(n);
        for (int i = 0; i < 31; i++) {
            if (sortedString(1 << i).equals(target)) return true;
        }
        return false;
    }

    private static String sortedString(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // Using HashMap

    public static boolean reorderedPowerOf2II(int n) {
        int[] target = frequency(n);
        for (int i = 0; i < 30; i++) {
            int powerOf2 = (int)Math.pow(2,i);
            if (checkEqual(target,frequency(powerOf2))){
                return true;
            }
        }
        return false;
    }

    public static int[] frequency(int n){
        int[] arr = new int[10];
        while (n > 0){
            arr[n%10]++;
            n /= 10;
        }
        return arr;
    }

    public static boolean checkEqual(int[] power,int[] target){
        for (int i = 0; i < power.length; i++) {
            if (power[i] != target[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(46));
        System.out.println(reorderedPowerOf2(218));
    }
}
