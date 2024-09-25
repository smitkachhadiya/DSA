import java.util.Arrays;
import java.util.Scanner;

public class mergeSortedArray {
    //88. Merge Sorted Array

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }

        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};
        int m = 3 , n=3;
        merge(arr1,m,arr2,n);
    }
}
