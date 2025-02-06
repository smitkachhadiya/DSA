import java.util.HashMap;
import java.util.Map;

public class tupleWithSameProduct {

    // 1726. Tuple with Same Product

    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer , Integer> product = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int p = nums[i] * nums[j];
                product.put(p,product.getOrDefault(p , 0)+1);
            }
        }

        for (int k : product.values()){
            if(k > 1){
                count += k * (k - 1) * 4;
//                count += ( 8 * (k * ( k - 1 )) / 2);    // both are valid
            }
        }

        System.out.println(product);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,4,12};
        System.out.println(tupleSameProduct(arr));
    }
}
