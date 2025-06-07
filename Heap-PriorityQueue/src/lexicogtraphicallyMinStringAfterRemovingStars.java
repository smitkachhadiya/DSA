import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lexicogtraphicallyMinStringAfterRemovingStars {

    //  3170. Lexicographically Minimum String After Removing Stars

    //  Method 1 : Using Priority Queue

    public static String clearStars(String s){
        char[] arr = s.toCharArray();
        List<Integer>[] position = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            position[i] = new ArrayList<>();
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c == '*'){
                char small = pq.peek();
                List<Integer> list = position[small - 'a'];
                int j = list.remove(list.size() - 1);
                arr[j] = '*';
                if(list.isEmpty()){
                    pq.poll();
                }
            } else{
                int temp = c - 'a';
                if(position[temp].isEmpty()){
                    pq.add(c);
                }
                position[temp].add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr){
            if(c != '*'){
                sb.append(c);
            }
        }
        return sb.toString();
    }


    // Method 2 : Using List ---------------------------------------------------------------------------------------------

    public static String clearStars1(String s){
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '*'){
                for (int j = 0; j < 26; j++) {
                    if(!list.get(j).isEmpty()){
                        int position = list.get(j).remove(list.get(j).size() - 1);
                        arr[position] = '*';
                        break;
                    }
                }
            } else{
                list.get(arr[i]-'a').add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                res.append(c);
            }
        }
        return res.toString();

    }

    // In following cod - got TLE for larger value -------------------------------------------------------------------------------

    public static String clearStars2(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if (ch != '*') {
                sb.append(ch);
            } else{
                if(sb.length() > 0){
                    char minChar = 'z' + 1;
                    int indexToRemove = -1;
                    for (int i = 0; i < sb.length(); i++) {
                        if (sb.charAt(i) <= minChar) {
                            minChar = sb.charAt(i);
                            indexToRemove = i;
                        }
                    }
                    sb.deleteCharAt(indexToRemove);
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearStars("ef*cba*hg*cb*"));
        System.out.println(clearStars("abcde*f*"));
        System.out.println(clearStars("abc*de*fgh*"));
        System.out.println(clearStars("aaba*"));
        System.out.println(clearStars("ee**"));
    }
}
