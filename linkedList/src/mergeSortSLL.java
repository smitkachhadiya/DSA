package DSA.dataSets.linklist;

public class mergeSortSLL {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left,right);
    }

    ListNode merge(ListNode list1,ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next =  list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head){
        ListNode midprev = null;
        while (head != null && head.next != null){
            midprev = (midprev == null) ? head : midprev.next;
            head = head.next.next;
        }
        ListNode mid = midprev.next;
        midprev.next = null;
        return mid;
    }
}
