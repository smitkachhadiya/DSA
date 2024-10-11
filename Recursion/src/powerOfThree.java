public class powerOfThree {

    // 326. Power of Three

    public boolean isPowerOfThree(int n) {
        if( n == 1){
            return true;
        } else if ( n <= 0 || n %3 != 0) {
            return false;
        }
        return isPowerOfThree(n/3);
    }

    public boolean isPowerOfThree2(int n){
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
