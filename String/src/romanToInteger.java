package DSA.Astring;

import java.util.HashMap;
import java.util.Hashtable;

public class romanToInteger {

    // 13. Roman to Integer

    public int romanToInt(String s) {
        HashMap<Character,Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        int total=0;
        int prev=0;

        for (int i = s.length()-1; i >= 0; i--) {
            char current = s.charAt(i);
            int currentVal = roman.get(current);

            if(currentVal < prev){
                total -= currentVal;
            }else {
                total += currentVal;
            }
            prev = currentVal;
        }

        return total;
    }
}
