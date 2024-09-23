package DSA.dataSets.linklist;

public class swapNodes {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 1721. Swapping Nodes in a Linked List
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        while(k > 1) {
            temp = temp.next;
            k--;
        }
        ListNode left = temp, right = head;
        while(temp.next != null) {
            temp = temp.next;
            right = right.next;
        }
        int value = left.val;
        left.val = right.val;
        right.val = value;
        return head;
    }

    public ListNode swapNodes2(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = new ListNode(0,head);
        int n = checkLength(head);
        System.out.println(n);
        if(k > n){
            return head;
        }
        ListNode temp1=new ListNode();
        ListNode temp2=new ListNode();

        for(int i=0; i < n ; i++){
            if(i == k){
                temp1 = temp;
            }
            if(i == n-k){
                temp2 = temp;
            }
            temp = temp.next;
        }

        int i = temp1.val;
        temp1.val = temp2.val;;
        temp2.val = i;
        return head;
    }

    int checkLength(ListNode temp){
        int len =0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
