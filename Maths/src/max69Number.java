public class max69Number {

    //  1323. Maximum 69 Number

    public static int maximum69Number (int num) {
        char[] s = String.valueOf(num).toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '6') {
                s[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(s));
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(6696));
    }
}
