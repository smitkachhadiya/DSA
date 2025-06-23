import java.util.Arrays;
import java.util.HashMap;

public class isomorphicString {

    //  205. Isomorphic Strings

    public static boolean isIsomorphic(String s, String t) {
        int[] sindex = new int[200];
        int[] tindex = new int[200];

        int n = s.length();

        if(s.length() != t.length()){
            return false;
        }

        for (int i = 0 ; i < n ; i++){
            if(sindex[s.charAt(i)] != tindex[t.charAt(i)]) {
                return false;
            }
            sindex[s.charAt(i)] = i+1;
            tindex[t.charAt(i)] = i+1;
        }

//        System.out.println(Arrays.toString(sindex));
//        System.out.println(Arrays.toString(tindex));

        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Character,Integer> sindex = new HashMap<>();
        HashMap<Character,Integer> tindex = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(!sindex.containsKey(s.charAt(i))){
                sindex.put(s.charAt(i),i);
            }

            if(!tindex.containsKey(t.charAt(i))){
                tindex.put(t.charAt(i),i);
            }

            if(!sindex.get(s.charAt(i)).equals(tindex.get(t.charAt(i)))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("egg","ade"));
        System.out.println(isIsomorphic("badc","baba"));
    }
}
