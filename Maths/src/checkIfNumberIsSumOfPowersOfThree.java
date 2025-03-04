public class checkIfNumberIsSumOfPowersOfThree {

    //   1780. Check if Number is a Sum of Powers of Three

    public static boolean checkPowersOfThree(int n) {
        while (n > 0){
            if(n % 3 == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThree(21));
    }
}
