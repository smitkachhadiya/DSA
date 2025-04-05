public class towerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        towerOfHaanoi(n,'A','B','C');
    }

    static void towerOfHaanoi(int n , char from_rod,char to_rod,char aux_rod){

        if(n == 0){
            return;
        }
        towerOfHaanoi(n-1,from_rod,aux_rod,to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHaanoi(n-1,aux_rod,to_rod,from_rod);
    }

}
