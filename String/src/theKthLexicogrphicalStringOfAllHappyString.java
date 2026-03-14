package DSA.Astring;

public class theKthLexicogrphicalStringOfAllHappyString {

    //  1415. The k-th Lexicographical String of All Happy Strings of Length n

    public static String getHappyString(int n, int k) {
        int size = (int) Math.pow(2, n - 1);
        if (3 * size < k) return "";

        String[] s = {"bc", "ac", "ab"};
        StringBuilder res = new StringBuilder();

        if (k <= size)
            res.append('a');
        else if (k <= 2 * size) {
            res.append('b');
            k -= size;
        }
        else {
            res.append('c');
            k -= 2 * size;
        }

        for (int i = 1; i < n; i++) {
            size /= 2;
            String ch = s[res.charAt(res.length() - 1) - 'a'];
            if (k <= size) res.append(ch.charAt(0));
            else {
                res.append(ch.charAt(1));
                k -= size;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getHappyString(1,3));
        System.out.println(getHappyString(1,4));
        System.out.println(getHappyString(3,9));
    }
}
