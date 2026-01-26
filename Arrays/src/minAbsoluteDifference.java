import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minAbsoluteDifference {

    //  1200. Minimum Absolute Difference

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(arr);
        int minDif=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            minDif=Math.min(minDif,arr[i]-arr[i-1]);
        }
        for(int i=1;i<arr.length;i++){
            if(minDif==arr[i]-arr[i-1]){
                list.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4,2,1,3}));
        System.out.println(minimumAbsDifference(new int[]{1,3,6,10,15}));
    }
}
