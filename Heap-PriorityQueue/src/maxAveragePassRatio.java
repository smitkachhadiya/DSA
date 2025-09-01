import java.util.Comparator;
import java.util.PriorityQueue;

public class maxAveragePassRatio {

    //  1792. Maximum Average Pass Ratio

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
                new Comparator<double[]>() {
                    public int compare(double[] a, double[] b) {
                        if (a[0] < b[0]) return 1;
                        if (a[0] > b[0]) return -1;
                        return 0;
                    }
                }
        );

        for (int i = 0; i < classes.length; i++) {
            double pass = classes[i][0];
            double total = classes[i][1];
            double increment = (pass +1.0) / (total+1.0) - pass/total;
            pq.offer(new double[]{increment,pass,total});
        }

        while (extraStudents > 0){
            double[] top = pq.poll();
            double pass = top[1]+1;
            double total = top[2]+1;
            double increment = (pass +1.0) / (total+1.0) - pass/total;
            pq.offer(new double[]{increment,pass,total});
            extraStudents--;
        }

        double sum = 0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) {
            double[] temp = (double[]) arr[i];
            sum += temp[1]/temp[2];
        }
        return sum/ classes.length;
    }

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}},2));
    }
}
