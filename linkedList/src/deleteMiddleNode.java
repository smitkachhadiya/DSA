public class deleteMiddleNode {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head== null || head.next == null){
            return null;
        }
        ListNode temp = middleNode(head);
        temp.next = temp.next.next;
        return head;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode beforeMiddle = null;

        while (fast != null && fast.next != null){
            beforeMiddle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return beforeMiddle;
    }
}
