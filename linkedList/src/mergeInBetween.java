
public class mergeInBetween {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // 1669. Merge In Between Linked Lists
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = new ListNode(-1);
        temp.next = list1;
        ListNode prev= temp;
        ListNode curr = temp;
        while(curr!=null && b+2>0){
            if(a+1>0){
                prev = curr;
                a--;
            }
            curr = curr.next;
            b--;
        }
        ListNode m = list2;
        while(m.next!=null){
            m = m.next;
        }
        prev.next = list2;
        m.next = curr;
        return temp.next;
    }


    public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode nodeA = new ListNode();
        ListNode nodeB = new ListNode();
        ListNode last2 = getLastNode(head2);
        int i = 0;
        while (head1 != null){
            if(i == a-1){
                nodeA = head1;
            }
            if(i == b+1){
                nodeB = head1;
            }
            head1 = head1.next;
            i++;
        }
        nodeA.next = list2;
        last2.next = nodeB;
        return list1;
    }

    public ListNode getLastNode(ListNode temp){
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }
}
