public class partitioningIntoMinNumberOfDeciBinaryNumbers {

    //  1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

    public static int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); ++i) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("23"));
        System.out.println(minPartitions("254168461433"));
        System.out.println(minPartitions("25416846143988773"));
    }
}
