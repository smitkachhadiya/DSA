public class containerWithMostWater {

    //  11. Container With Most Water

    // Optimized
    public static int maxArea(int[] height) {
        int left =0 , right = height.length-1;
        int ans = 0;
        while(left < right){
            int small = Math.min(height[left],height[right]);
            ans = Math.max(ans , small*(right-left));

            while (left < right && height[left] <=small){
                left++;
            }
            while (left < right && height[right] <=small){
                right--;
            }
        }

        return ans;
    }

    public static int maxArea2(int[] height) {
        int left =0 , right = height.length-1;
        int ans = 0;
        while(left < right){
            int small = Math.min(height[left],height[right]);
            ans = Math.max(ans , small*(right-left));

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea(new int[]{1,1}));
    }
}
