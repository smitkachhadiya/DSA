import java.util.Arrays;
import java.util.Map;

public class candy {

    //  135. Candy

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);


        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]){
                candies[i] = 1+candies[i-1];
            }
        }

        int total = candies[n-1];
        for (int i = n-1; i >0 ; i--) {
            if (ratings[i-1] > ratings[i]){
                candies[i-1] = Math.max(candies[i-1] , 1 + candies[i]);
            }
            total += candies[i-1];
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{1,2,2}));
        System.out.println(candy(new int[]{5,4,2,6,6,6,7,8,3}));
    }
}
