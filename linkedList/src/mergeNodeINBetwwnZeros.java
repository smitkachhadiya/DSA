package DSA.dataSets.linklist;

public class mergeNodeINBetwwnZeros {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    //2181. Merge Nodes in Between Zeros

    public ListNode mergeNodes(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode ans = new ListNode(0,null);
        ListNode temp = ans;
        int sum = 0;
        ListNode current = head.next;

        while (current != null){
            if(current.val != 0){
               sum += current.val;
            }else{
                if(sum > 0){
                    temp.next = new ListNode(sum);
                    temp = temp.next;
                    sum = 0;
                }
            }
            current = current.next;
        }
        return ans.next;
    }
}
