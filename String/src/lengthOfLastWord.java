package DSA.Astring;

public class lengthOfLastWord {

    // 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;
    }
}
