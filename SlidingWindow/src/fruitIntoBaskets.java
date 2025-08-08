import java.util.HashMap;

public class fruitIntoBaskets {

    //  904. Fruit Into Baskets

    public static int totalFruit(int[] fruits) {
        int start = 0 , end = 0 , maxLen = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (end < n){
            map.put(fruits[end], map.getOrDefault(fruits[end],0)+1);
            while (map.size() >= 3){
                map.put(fruits[start],map.get(fruits[start])-1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            int currLen = end - start +1;
            maxLen = Math.max(currLen,maxLen);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,1,2}));
        System.out.println(totalFruit(new int[]{1,1,2,2,3}));
        System.out.println(totalFruit(new int[]{1,2,1,2,3}));
    }
}
