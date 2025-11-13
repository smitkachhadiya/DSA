public class maxNumberOfOperationsToMoveOnesToEnd {

    //  3228. Maximum Number of Operations to Move Ones to the End

    public static int maxOperations(String s) {
        int ones = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                ones++;
            else if (i > 0 && s.charAt(i - 1) == '1')
                res += ones;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations("1001101"));
        System.out.println(maxOperations("1001101000"));
        System.out.println(maxOperations("00111"));
    }
}
