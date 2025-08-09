public class powerOfTwo {

    //  231. Power of Two

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (1<<30)%n == 0;
    }

    public static boolean isPowerOfTwo3(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo2(8));
        System.out.println(isPowerOfTwo(845));
    }
}
