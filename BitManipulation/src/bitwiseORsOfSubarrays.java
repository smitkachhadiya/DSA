import java.util.HashSet;
import java.util.Set;

public class bitwiseORsOfSubarrays {

    //  898. Bitwise ORs of Subarrays

    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            ans.add(arr[i]);
            for(int j=i-1;j>=0;j--){
                if(arr[j]==(arr[j] | arr[i])){
                    break;
                }
                arr[j]|=arr[i];
                ans.add(arr[j]);
            }
        }
        return ans.size();
    }

    public static int subarrayBitwiseORs2(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for (int i : arr){
            Set<Integer> temp = new HashSet<>();
            temp.add(i);
            for(int j : current){
                temp.add(j | i);
            }
            current = temp;
            ans.addAll(current);
        }
        return ans.size();
    }

    public static void main(String[] args) {
        System.out.println(new int[]{1,2,4});
        System.out.println(new int[]{1,1,2});
    }
}
