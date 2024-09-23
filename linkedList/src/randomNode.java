package DSA.dataSets.linklist;

import java.util.ArrayList;
import java.util.Random;

public class randomNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //382. Linked List Random Node
    ArrayList<Integer>list=new ArrayList<>();
    static Random random = new Random();
    public void Solution(ListNode head) {
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    // other

    public void Solution2(ListNode head) {
        ListNode current = head;
        int len=0;
        int j = getRandom();
        while (current != null){
            if(j == len){
                System.out.println(current.val);
                return;
            }
            len++;
            current = current.next;
        }
    }

    public int getRandom2() {
        Random r = new Random();
        int n = r.nextInt(3);
        int n1 = r.nextInt(0,3);
        return n;
    }
}
