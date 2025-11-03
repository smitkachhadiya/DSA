public class minTimeToMakeRopeColorful {

    //  1578. Minimum Time to Make Rope Colorful

    //  Method 1
    public static int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                int total = neededTime[i - 1];
                int max = neededTime[i - 1];
                while (i < arr.length && arr[i] == arr[i - 1]) {
                    total += neededTime[i];
                    max = Math.max(max, neededTime[i]);
                    i++;
                }
                res += total - max;
            }
        }
        return res;
    }

    //  Method 2
    public static int minCost2(String colors, int[] neededTime) {
        int n = colors.length(), sum = 0;
        for (int i = 1; i < n; i++) {
            int maxi = 0;
            while (i < n && colors.charAt(i) == colors.charAt(i - 1)) {
                sum += neededTime[i - 1];
                maxi = Math.max(maxi, neededTime[i - 1]);
                i++;
            }
            sum += neededTime[i - 1];
            maxi = Math.max(maxi, neededTime[i - 1]);
            if (maxi != 0) sum -= maxi;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minCost("abaac",new int[]{1,2,3,4,5}));
        System.out.println(minCost("aabaa",new int[]{1,2,3,4,1}));
    }
}
