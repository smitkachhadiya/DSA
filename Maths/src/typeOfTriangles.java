public class typeOfTriangles {

    // 3024. Type of Triangle

    public static String triangleType(int[] nums) {
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return "equilateral";
        else if ((nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
                && nums[0] + nums[1] > nums[2]
                && nums[1] + nums[2] > nums[0]
                && nums[0] + nums[2] > nums[1])
            return "isosceles";
        else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[0] != nums[2]
                && nums[0] + nums[1] > nums[2]
                && nums[1] + nums[2] > nums[0]
                && nums[0] + nums[2] > nums[1])
            return "scalene";
        return "none";
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5};
        System.out.println(triangleType(nums));
    }
}
