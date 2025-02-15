public class findThePunishmentNumberOfInteger {

    //  2698. Find the Punishment Number of an Integer

    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (partition(String.valueOf(square), 0, i)) {
                sum += square;
            }
        }
        return sum;
    }

    private static boolean partition(String s , int index , int target){
        if (index == s.length()) {
            return target == 0;
        }
        int num = 0;
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > target) {
                break;
            }
            if (partition(s, i + 1, target - num)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        System.out.println(punishmentNumber(37));
        System.out.println(punishmentNumber(49));


    }
}
