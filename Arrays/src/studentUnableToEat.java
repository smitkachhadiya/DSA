
import java.util.LinkedList;
import java.util.Queue;

public class studentUnableToEat {
    // 1700. Number of Students Unable to Eat Lunch

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0,i=0;
        for (int a : students){
            queue.add(a);
        }
        while (!queue.isEmpty() && count != queue.size()){
            if(queue.peek() == sandwiches[i]){
                count = 0;
                queue.remove();
                i++;
            }else{
                queue.add(queue.remove());
                count++;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[] student = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(countStudents(student,sandwiches));
    }
}
