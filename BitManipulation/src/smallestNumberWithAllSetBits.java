public class smallestNumberWithAllSetBits {

    //  3370. Smallest Number With All Set Bits

    public static int smallestNumber(int n) {
        int x = n;
        while ((x & (x + 1)) != 0){
            x++;
        }

        return x;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(7));
        System.out.println(smallestNumber(15));
        System.out.println(smallestNumber(159));
    }
}
