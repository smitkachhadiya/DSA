public class middleNodeOfLinklist {

    class ListNode{
        int val;
        ListNode next;

        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }

    public ListNode head = null;
    public ListNode tail = null;

    // 876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
