public class reOrderList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMid(head);

        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
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
    public  ListNode findMid(ListNode temp){
        ListNode f = temp;
        ListNode s = temp;

        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
