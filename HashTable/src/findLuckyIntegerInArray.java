import java.util.HashMap;

public class findLuckyIntegerInArray {

    //  1394. Find Lucky Integer in an Array

    public static int findLucky(int[] arr) {
        int ans = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (int i : map.keySet()){
            if(map.get(i) == i){
                ans = Math.max(ans,i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,3,4}));
        System.out.println(findLucky(new int[]{1,2,2,3,3,3}));
    }

}
