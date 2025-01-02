public class powerOfN {
    // 50. Pow(x, n)

    public static double myPow(double x, int n) {
        return countPower(x, (long) n);
    }

    public static  double countPower(double x , double n ){
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 1.0 / countPower(x , -n);
        }

        if(n %2 == 1){
            return x * countPower(x*x,(n-1)/2);
        }else {
            return countPower(x*x , n/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(10,2));
    }
}
