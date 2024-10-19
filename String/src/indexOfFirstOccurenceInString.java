package DSA.Astring;

public class indexOfFirstOccurenceInString {
    
    // 28. Find the Index of the First Occurrence in a String

    public static int strStr(String haystack, String needle) {
        if(haystack.isEmpty()){
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","ell"));
    }

}
