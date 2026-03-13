public class minNumSecondsToMakeMountainHeightZero {

    //  3296. Minimum Number of Seconds to Make Mountain Height Zero

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int max = 0;
        for (int x : workerTimes)
            max = Math.max(max, x);

        int h = (mountainHeight-1) / workerTimes.length + 1;
        long left = 1, right = (long) max * h * (h + 1) / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mountainHeight, workerTimes, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private boolean  check(int mountainHeight, int[] workerTimes, long time) {
        for (int x : workerTimes) {
            mountainHeight -= (int)(-1 + Math.sqrt(1 + 8 * time / x)) / 2;
            if (mountainHeight <= 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        minNumSecondsToMakeMountainHeightZero mn = new minNumSecondsToMakeMountainHeightZero();
        System.out.println(mn.minNumberOfSeconds(10,new int[]{3,2,2,4}));
        System.out.println(mn.minNumberOfSeconds( 5,new int[]{1}));
    }
}
