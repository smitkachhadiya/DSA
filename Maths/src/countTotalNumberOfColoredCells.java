public class countTotalNumberOfColoredCells {

    //  2579. Count Total Number of Colored Cells

    public static long coloredCells(int n) {
        return 1+(long)2*n*(n-1);
    }

    public static long coloredCells2(int n) {
        long count = 1 ;
        long jump = 4;

        while (n > 1){
            count += jump;
            jump += 4;
            n--;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
        System.out.println(coloredCells(3));
        System.out.println(coloredCells(5));
    }
}
