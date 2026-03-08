public class findUniqueBinaryString {

    //  1980. Find Unique Binary String

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        findUniqueBinaryString ubs = new findUniqueBinaryString();
        System.out.println(ubs.findDifferentBinaryString(new String[]{"00","01"}));
        System.out.println(ubs.findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}
