public class powerofTwo {

    // 231. Power of Two

    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        } else if(n == 0 || n %2 != 0){
            return false;
        }

        return isPowerOfTwo(n/2);
    }

    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }
}
