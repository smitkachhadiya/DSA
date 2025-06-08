public class transformArrayToAllEqualElements {

    //  3576. Transform Array to All Equal Elements

    //  Weekly Contest 453

    public static boolean canMakeEqual(int[] nums, int k) {
        return (makeEqual(nums.clone(),1) <=k || makeEqual(nums.clone(),-1) <= k);
    }

    public static int makeEqual(int[] arr , int target){
        int count =0;
        int n = arr.length;
        for(int i=0 ; i < n-1 ; i++){
            if(arr[i] != target){
                arr[i] *= -1;
                arr[i+1] *= -1;
                count++;
            }
        }
        if(arr[n-1] != target){
            return Integer.MAX_VALUE;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(canMakeEqual(new int[]{1,-1,1,-1,1},3));
        System.out.println(canMakeEqual(new int[]{-1,-1,-1,1,1,1},5));
    }
}
