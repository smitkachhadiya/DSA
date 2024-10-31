public class splitLinkedListInParts {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 725. Split Linked List in Parts
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLength(head);
        int size = len/k;
        int extra = len%k;

        ListNode[] ans = new ListNode[k];

        ListNode temp = head;

        for(int i=0 ; i < k ; i++){
            ListNode tempHead = temp;
            ListNode prev = null;

            int nodeSize = size + (extra > 0 ? 1 : 0);
            extra--;

            for (int j=0 ; j < nodeSize ; j++){
                if(temp != null){
                    prev = temp;
                    temp = temp.next;
                }
            }

            if (prev != null) {
                prev.next = null;
            }

            ans[i] = tempHead;
        }
        return ans;
    }

    public int getLength(ListNode temp){
        int len = 0;
        while (temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }

}
