public class pattern {
    public static void main(String[] args) {
        printPattern(7);
    }

    static void pattern1(int n){

        for(int row = 0 ; row < n*2 ; row++){
            int totalCOlToPrint = row > n ? 2*n - row -1 : row;
            for (int col = 0 ; col <totalCOlToPrint ; col++){
                    System.out.print("* ");
            }
            System.out.println("");
        }
    }

    static void pattern2(int n){
        for(int row=0 ; row < n*2 ; row++){
            int spaceToPrint = row > n ? row-n : n-row;
            int colToPrint = row > n ? n*2 - row : row;
            for (int space = 0 ; space <spaceToPrint ; space++){
                System.out.print(" ");
            }

            for (int col = 0 ; col <colToPrint ; col++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    static void pattern3(int n){
        int spaceToPrint = 0;
        for (int row = 1 ; row < n*2; row++){
            if(row ==1 || row == n*2-1){
                for(int i = 0 ; i < n*2-1 ; i++){
                    System.out.print('*');
                }
                System.out.println("");
            }else {
                spaceToPrint = row > n ? spaceToPrint-1 : spaceToPrint+1;
                int firstStars = row > n ? row-n : n-row;
                for(int col = 0 ; col <=firstStars ; col++){   //printing first stars
                    System.out.print("*");
                }

                for (int space=0 ; space < spaceToPrint ; space++ ){
                    System.out.print(" ");
                }
                for(int col = 0 ; col <=firstStars ; col++){   //printing first stars
                    System.out.print("*");
                }
                spaceToPrint = row >= n ? spaceToPrint-1 : spaceToPrint+1;
                System.out.println("");
            }

        }
    }

    public static void printPattern(int n) {
        // Width of the pattern is 2 * n - 1
        int width = 2 * n - 1;

        // Print the top half of the pattern including the middle line
        for (int row = 0; row < n; row++) {
            // Print leading stars
            for (int col = 0; col < n - row - 1; col++) {
                System.out.print('*');
            }

            // Print spaces in between
            if (row > 0) {
                for (int col = 0; col < 2 * row - 1; col++) {
                    System.out.print(' ');
                }
            }

            // Print trailing stars
            if (row >= 0) {
                for (int col = 0; col < n - row - 1; col++) {
                    System.out.print('*');
                }
            }

            // Move to the next line
            System.out.println();
        }

        // Print the bottom half of the pattern
        for (int row = n - 2; row >= 0; row--) {
            // Print leading stars
            for (int col = 0; col < n - row - 1; col++) {
                System.out.print('*');
            }

            // Print spaces in between
            if (row > 0) {
                for (int col = 0; col < 2 * row - 1; col++) {
                    System.out.print(' ');
                }
            }

            // Print trailing stars
            if (row >=0) {
                for (int col = 0; col < n - row - 1; col++) {
                    System.out.print('*');
                }
            }

            // Move to the next line
            System.out.println();
        }
    }
    

}
