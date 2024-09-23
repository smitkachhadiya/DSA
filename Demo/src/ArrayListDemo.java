import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> items = new ArrayList<>();

        for (int i = 1 ; i <= 10 ; i++) {
            items.add(sc.nextInt());
        }
        System.out.println(items);
        System.out.print("Enter the index number : ");
        int index = sc.nextInt();
        System.out.println(items.get(index));

    }
}
