public class capacityToShipPackageWithinDDays {

    //  1011. Capacity To Ship Packages Within D Days

    public static int shipWithinDays(int[] weights, int days) {
        int total = 0, heaviest = 0;
        for (int w : weights) {
            total += w;
            heaviest = Math.max(heaviest, w);
        }

        int low = Math.max(heaviest, total / days);  // tighter lower bound
        int high = heaviest * (int) Math.ceil((double) weights.length / days); // tighter upper bound
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isShipped(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isShipped(int[] weights, int days , int mid){
        int daysRequired = 1;
        int currentLoad = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > mid) {
                return false;
            }

            currentLoad += weights[i];

            if (currentLoad > mid) {
                daysRequired++;
                currentLoad = weights[i];
            }
        }

        return daysRequired <= days;
    }

    public static int shipWithinDays2(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i : weights){
            left = Math.min(i , left);
            right += i;
        }

        int ans = 0;

        while (left <= right){
            System.out.println(left + " " + right);
            int mid = left + (right - left) / 2;
            if(isShipped(weights,days,mid)){
                ans = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5));
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4},3));
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1},4));
    }
}
