package DSA.dataSets.linklist;

public class reverseSLL {

    class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    //206. Reverse Link List
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

    //92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        for(int i=0 ; current!= null && i < left -1 ; i++){
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;
        ListNode next = current.next;
        for(int i=0  ; current!= null && i < right -left +1 ; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = current;
      return head;
    }

    //25. Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2){
            return head;
        }
        int len = getLength(head);
        ListNode prev = null;
        ListNode current = head;
        while (len >= k){
            ListNode last = prev;
            ListNode newEnd = current;
            ListNode next = current.next;
            for(int i=0  ; current!= null && i < k; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }
            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = current;
            if(current == null){
                break;
            }
            prev= newEnd;
            len -= k;
        }
        return head;
    }

    public int getLength(ListNode temp){
        int n = 0;
        while (temp != null){
            temp = temp.next;
            n++;
        }
        return n;
    }
}
