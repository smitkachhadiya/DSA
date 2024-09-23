package DSA.dataSets.linklist;

public class partitionList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    // 86. Partition List


    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        ListNode temp = head;
        while (temp != null){
            if(temp.val < x){
                less.next = temp;
                less = less.next;
            }else {
                greater.next = temp;
                greater = greater.next;
            }
            temp = temp.next;
        }

        greater.next = null;
        less.next = greaterHead.next;


        return lessHead.next;
    }
}
