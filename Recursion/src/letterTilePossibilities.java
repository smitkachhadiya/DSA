public class letterTilePossibilities {

    // 1079. Letter Tile Possibilities

    public static int numTilePossibilities(String tiles) {
        int[] arr = new int[26];
        for (char c : tiles.toCharArray()){
            arr[c - 'A']++;
        }
        return countPossibilities(arr);
    }

    private static int countPossibilities(int[] arr){
        int ways = 0;
        for (int i = 0; i < 26; i++) {
            if(arr[i] > 0){
                arr[i]--;
                ways += 1 + countPossibilities(arr);
                arr[i]++;
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("ABC"));
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));

    }
}
