public class minOperationsToMakeTheIntegerZero {

    // 2749. Minimum Operations to Make the Integer Zero

    public static int makeTheIntegerZero(int num1, int num2) {
        for(int i=1;i<=60;i++){
            long num = (long)num1 - (long)i*num2;
            if(num < i) continue;
            // System.out.println(Long.toBinaryString(num) + " : " + Long.bitCount(num));
            if(Long.bitCount(num) <= i){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(makeTheIntegerZero(3,-2));;
        System.out.println(makeTheIntegerZero(5,7));;
        System.out.println(makeTheIntegerZero(512,89));;
    }
}
