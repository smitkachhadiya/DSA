package DSA.Astring;

public class largest3SameDigitNumberInString {

    //  2264. Largest 3-Same-Digit Number in String

    public static String largestGoodInteger(String num) {
        String[] numbers = {"999","888","777","666","555","444","333","222","111","000"};
        for (String s : numbers) {
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }

    public static String largestGoodInteger2(String num) {
        String best = "";
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                best = best.compareTo(num.substring(i, i+3)) > 0 ? best : num.substring(i, i+3);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("42352338"));
    }
}
