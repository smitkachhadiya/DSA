import java.util.ArrayList;
import java.util.HashMap;

public class shortCharacterByFrequency {

    //  451. Sort Characters By Frequency

    public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) -map.get(a));
        StringBuilder sb = new StringBuilder();

        for(char ch : list){
            int freq = map.get(ch);
            for(int i = 0; i<freq; i++){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("bfjebyfbebf"));
        System.out.println(frequencySort("bfjebyfbebfwfewufhief"));
    }
}
