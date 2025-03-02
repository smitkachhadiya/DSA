import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeTwo2DArrayBySummingValues {

    //  2570. Merge Two 2D Arrays by Summing Values

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int n1 = nums1.length , n2 = nums2.length;
        int p1 = 0,p2 = 0;

        while (p1 < n1 && p2 < n2){
            if(nums1[p1][0] == nums2[p2][0]){
                result.add(new int[]{nums1[p1][0] , nums1[p1][1] + nums2[p2][1] });
                p1++;
                p2++;
            } else if(nums1[p1][0] < nums2[p2][0]){
                result.add(nums1[p1]);
                p1++;
            } else {
                result.add(nums2[p2]);
                p2++;
            }
        }

        while (p1 < n1) {
            result.add(nums1[p1]);
            p1++;
        }

        while (p2 < n2) {
            result.add(nums2[p2]);
            p2++;
        }

        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3},{4,5}};
        int[][] arr2 = {{1,4},{3,2},{4,1}};
        for (int[] ele : mergeArrays(arr1,arr2)){
            System.out.println(Arrays.toString(ele));
        }
    }
}
