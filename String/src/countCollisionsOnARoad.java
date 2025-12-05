package DSA.Astring;

public class countCollisionsOnARoad {

    //  2211. Count Collisions on a Road

    public static int countCollisions(String directions) {
        int count = 0;
        int left = 0, right = directions.length() - 1;
        char[] s = directions.toCharArray();

        while (left < s.length && s[left] == 'L') left++;
        while (right>=0 && s[right]=='R') right--;

        for (int i = left; i <= right; i++){
            if (s[i] != 'S') count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL"));
        System.out.println(countCollisions("LLRR"));
        System.out.println(countCollisions("SLLRLSRSR"));
    }
}
