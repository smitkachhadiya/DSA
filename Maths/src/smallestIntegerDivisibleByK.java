public class smallestIntegerDivisibleByK {

    //  1015. Smallest Integer Divisible by K

    public static int smallestRepunitDivByK(int k) {
        if (k == 1) return 1;
        if(k%2 == 0 || k%5 == 0) return -1;

        int remainder = 0;
        for (int i=1 ; i<=k ; i++){
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return i;
        }
         return -1;
    }

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(1));
        System.out.println(smallestRepunitDivByK(2));
        System.out.println(smallestRepunitDivByK(3));
    }
}
