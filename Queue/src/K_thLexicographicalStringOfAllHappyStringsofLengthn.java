import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class K_thLexicographicalStringOfAllHappyStringsofLengthn {

    // 1415. The k-th Lexicographical String of All Happy Strings of Length n

    public static String getHappyString(int n, int k) {
        Queue<String> queue = new LinkedList<>();
        List<String> happyString = new ArrayList<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        while (!queue.isEmpty()){
            String curr = queue.poll();
            if(curr.length() == n){
                happyString.add(curr);
                continue;
            }
            char lastChar = curr.charAt(curr.length() - 1);
            if(lastChar == 'a'){
                queue.offer(curr + "b");
                queue.offer(curr + "c");
            } else if (lastChar == 'b') {
                queue.offer(curr + "a");
                queue.offer(curr + "c");
            } else {
                queue.offer(curr + "a");
                queue.offer(curr + "b");
            }
        }

        if(happyString.size() < k){
            return "";
        }
        return happyString.get(k-1);
    }

    public static void main(String[] args) {
        System.out.println(getHappyString(1,3));
        System.out.println(getHappyString(1,4));
        System.out.println(getHappyString(3,9));
        System.out.println(getHappyString(2,4));
    }


}
