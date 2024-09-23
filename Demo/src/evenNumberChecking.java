package DSA.src;

import java.util.ArrayList;

public class evenNumberChecking {
    public static void main(String[] args) {
        int[] arr = {10 , 1 , 1254 , -16 ,0 , 589 , 63 , 5 , 236598 , 0};
        ArrayList<Integer> ans = count(arr);
        System.out.println(ans);
    }

    static ArrayList<Integer> count(int[] arr){
        ArrayList<Integer> evennum = new ArrayList<>();
        for (int i = 0 ; i < arr.length ; i++){
            int passingnumber = arr[i];

            if (passingnumber < 0){
                passingnumber = passingnumber* -1;
            }
            if (passingnumber == 0){
                continue;
            }
            if(method3(passingnumber)){
                evennum.add(arr[i]);
            }
        }
        return evennum;
    }

    // checking number contains even number of digits
    static boolean method1(int n){
        int count = 0;
        while (n > 0){
            count++;
            n = n/10;
        }
        if (count%2 == 0){
            return true;
        }
        return false;
    }

    // checking number contains even number of digits by converting it into string
    static boolean method2(int n){
        String check = n + "";
        if(check.length()%2 == 0){
            return true;
        }
        return false;
    }

    static boolean method3(int n){
       int value = (int) Math.log10(n) +1;
        if (value%2 == 0){
            return true;
        }
        return false;
    }
}
