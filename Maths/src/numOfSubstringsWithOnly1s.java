public class numOfSubstringsWithOnly1s {
    
    //  1513. Number of Substrings With Only 1s

    public static int numSub(String s) {
        char[] chars = s.toCharArray();
        long ans = 0, count = 0;
        for (char c : chars) {
            if (c == '1') {
                count++;
            } else {
                ans += count * (count + 1) / 2;
                count = 0;
            }
        }
        ans += count * (count + 1) / 2;
        return (int) (ans % 1000000007);
    }

    public static int numSub2(String s) {
        long cnt = 0, total = 0, mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt = 0;
            }
            total = (total + cnt) % mod;
        }
        return (int) total;
    }

    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
        System.out.println(numSub("101"));
        System.out.println(numSub("111111"));
    }

}
