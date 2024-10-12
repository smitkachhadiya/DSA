public class powerOfFour {

    // 342. Power of Four
    public boolean isPowerOfFour(int n) {
        if( n == 1){
            return true;
        } else if ( n <= 0 || n %4 != 0) {
            return false;
        }
        return isPowerOfFour(n/4);
    }

}
