import java.util.HashMap;

public class romanToInteger {

    // 13. Roman to Integer

    public static int romanToInteger(String s){
        HashMap<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanToInt.get(currentChar);

            // Apply the subtraction rule
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }
        return total;
    }
    public static void main(String[] args){
        int num = romanToInteger("LVIII");
        System.out.println(num);
    }
}
