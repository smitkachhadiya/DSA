package DSA.dataSets.linklist;

public class interactionOfTwoLinkList {
    // 160. Intersection of Two Linked Lists

    class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public middleNodeOfLinklist.ListNode getIntersectionNode(middleNodeOfLinklist.ListNode headA, middleNodeOfLinklist.ListNode headB) {
        middleNodeOfLinklist.ListNode temp1 = headA;
        middleNodeOfLinklist.ListNode temp2 = headB;
        int len1=checkLength(headA);
        int len2=checkLength(headB);

        if(len1 > len2){
            while (len1 > len2){
                len1--;
                temp1 = temp1.next;
            }
        } else if (len2 > len1) {
            while (len2 > len1){
                len2--;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null || temp2 != null) {
            if(temp1 == temp2){
                return temp1;
            }
        }
        return null;
    }

    int checkLength(middleNodeOfLinklist.ListNode temp){
        int len =0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
