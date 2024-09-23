package DSA.src;

public class setBits {
    public static void main(String[] args) {
        int n=45;
        System.out.println(set_bits(n));

    }

    private static int set_bits(int n) {
        int count=0;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.bitCount(n));    // method 1

        while (n>0){
            count++;
            n = n - (n & -n);                  // method 2
        }

//        while (n>0){
//            count++;
//            n = n & n-1;                  // method 2
//        }
        return count;
    }
}
