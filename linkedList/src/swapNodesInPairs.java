package DSA.dataSets.linklist;

public class swapNodesInPairs {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // 24. Swap Nodes in Pairs

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;


        while (head!= null && head.next != null){
            ListNode f = head;
            ListNode s = head.next;
            f.next = s.next;
            s.next = f;
            prev.next = s;

            prev = f;
            head = f.next;
        }
        return dummy.next;
    }
}
