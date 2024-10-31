public class removeDublicateNode {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //82. Remove Duplicates from Sorted List II
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ansHead = new ListNode(0,head);
        ListNode c = head;
        ListNode n = ansHead;

        while (c != null){
            if(c.next != null && c.val == c.next.val){
                while (c.next != null && c.val == c.next.val){
                    c = c.next;
                }
                n.next = c.next;
            }else {
                n = n.next;
            }
            c = c.next;
        }

        return ansHead.next;
    }
}
