public class divisibleAndNonDivSumsDifference {

    // 2894. Divisible and Non-divisible Sums Difference

    public static int differenceOfSums(int n, int m) {
        return n * (n + 1) / 2 - m * (n / m) * (n / m + 1);
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSums(1,10));
    }
}
