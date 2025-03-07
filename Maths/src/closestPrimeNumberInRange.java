import java.util.Arrays;

public class closestPrimeNumberInRange {

    // 2523. Closest Prime Numbers in Range

    public static int[] closestPrimes(int left, int right) {
        if (right < 2) {
            return new int[]{-1, -1};
            }
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int prevPrime = -1, first = -1, second = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        minDiff = diff;
                        first = prevPrime;
                        second = i;
                    }
                }
                prevPrime = i;
            }
        }

        return (first == -1) ? new int[]{-1, -1} : new int[]{first, second};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10,19)));
        System.out.println(Arrays.toString(closestPrimes(4,6)));
        System.out.println(Arrays.toString(closestPrimes(10,200)));
        System.out.println(Arrays.toString(closestPrimes(19,23)));
        System.out.println(Arrays.toString(closestPrimes(1,1000000)));
    }
}
