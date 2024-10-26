import java.util.List;

public class insertionSortList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 147. Insertion Sort List

    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode prev = temp;

            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode nextTemp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = nextTemp;
        }
        return temp.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0),curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            ListNode prev = dummy;
            ListNode nxt = dummy.next;

            while (nxt != null) {
                if(nxt.val > curr.val)
                    break;
                prev = nxt;
                nxt = nxt.next;
            }
            curr.next = nxt;
            prev.next = curr;
            curr = temp;
        }
        return dummy.next;
    }
}
