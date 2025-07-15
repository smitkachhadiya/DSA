package DSA.Astring;

public class validWord {

    //  3136. Valid Word

    public static boolean isValid(String word) {
        int n = word.length();
        if (n < 3) {
            return false;
        }

        int vowels = 0;
        int consonants = 0;

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return vowels >= 1 && consonants >= 1;
    }

    public static void main(String[] args) {
        System.out.println(isValid("234senj"));
        System.out.println(isValid("234snj&"));
        System.out.println(isValid("23"));
        System.out.println(isValid("23g"));
    }
}
