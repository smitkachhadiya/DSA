import java.util.Arrays;

public class DIStringMatch {

    // 942. DI String Match

    public static int[] diStringMatch(String s) {
        int inc = 0;
        int dec = s.length();
        int[] arr = new int[s.length() +1];

        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == 'I'){
                arr[i] = inc;
                inc++;
            }else {
                arr[i] = dec;
                dec--;
            }
        }
        arr[s.length()] = inc;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));
        System.out.println(Arrays.toString(diStringMatch("DDD")));
    }
}
