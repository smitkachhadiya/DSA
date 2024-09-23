
public class addTwoNumber {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int a = 12;
        System.out.println(a%10);
    }

    // 2. Add to number
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // to check edge case for both list are empty
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            // Move to the next nodes in l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //445. Add Two Numbers II

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers(reverseList(l1),reverseList(l2));
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
