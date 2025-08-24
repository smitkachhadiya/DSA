public class minNoOfDaysToMakeMBouquets {

    //  1482. Minimum Number of Days to Make m Bouquets

    public static int minDays(int[] bloomDay, int m, int k) {
        if((int)m*k > bloomDay.length){
            return -1;
        }
        int low = 1 , high =(int) 1e9;
        while (low < high){
            int mid = low + (high - low) / 2;

            if(isPossible(bloomDay,m,k,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static boolean isPossible(int[] bloomDay, int m, int k,int days){
        int total = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            int count=0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= days) {
                count++;
                i++;
            }
            if(count == k){
                total++;
                i--;
            }
            if(total >= m){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7},2,3));
        System.out.println(minDays(new int[]{1,10,3,10,2},3,1));
    }
}
