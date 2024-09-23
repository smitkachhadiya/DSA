package DSA.dataSets.linklist;

public class removeNodes {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 2487. Remove Nodes From Linked List
    public ListNode removeNodes(ListNode head) {
        ListNode temp = reverse(head);
        if(temp == null || temp.next == null){
            return temp;
        }
        ListNode ans = new ListNode(temp.val,null);
        ListNode tempAns = ans;

        while (temp.next != null){
            temp = temp.next;
            if(tempAns.val <= temp.val){
                tempAns.next = new ListNode(temp.val,null);
                tempAns = tempAns.next;
            }
        }
        return reverse(ans);
    }

    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode current = head;
        ListNode prev = null;
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
