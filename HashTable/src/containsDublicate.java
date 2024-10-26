import java.util.HashSet;

public class containsDublicate{

    // 217. Contains Duplicate

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> a = new HashSet<>();
        for(int num : nums){
            if(a.contains(num)){
                return true;
            }
            a.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
}
