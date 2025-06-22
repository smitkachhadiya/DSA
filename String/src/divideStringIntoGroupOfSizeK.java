package DSA.Astring;

import java.util.ArrayList;
import java.util.Arrays;

public class divideStringIntoGroupOfSizeK {

    //  2138. Divide a String Into Groups of Size k

    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] result = new String[groups];

        for (int i = 0; i < groups; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                int index = i * k + j;
                if (index < n) {
                    sb.append(s.charAt(index));
                } else {
                    sb.append(fill);
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghi",3,'x')));
        System.out.println(Arrays.toString(divideString("abcdefghij",3,'x')));
    }
}
