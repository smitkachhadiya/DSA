package DSA.dataSets.linklist;

public class insertGCD {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //2807. Insert Greatest Common Divisors in Linked List
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tempA = head;
        ListNode tempB = head.next;

        while (tempB != null){
            ListNode gcd = new ListNode(getGCD(tempA.val,tempB.val));
            gcd.next = tempB;
            tempA.next = gcd;

            tempA = tempB;
            tempB = tempB.next;
        }
        return head;
    }

    public int getGCD(int a,int b){
        if(a==0){
            return b;
        }
        return getGCD(b%a,a);
    }
}
