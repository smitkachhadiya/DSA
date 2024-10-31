public class doubleANumber {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //2816. Double a Number Represented as a Linked List
    public ListNode doubleIt(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode ans = reverseList(head);
        ListNode current = ans;
        int carry = 0;
        while (current != null){
            int newval = (current.val * 2) + carry;
            current.val = newval%10;
            carry = newval/10;
            if(current.next == null && carry > 0){
                current.next = new ListNode(carry);
                carry= 0;
                return reverseList(ans);
            }
            current = current.next;
        }
        return reverseList(ans);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        if(head == null){
            return null;
        }
        ListNode next = current.next;

        while (current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
