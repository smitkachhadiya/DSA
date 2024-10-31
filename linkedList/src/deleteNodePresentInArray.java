import java.util.HashSet;
import java.util.Set;

public class deleteNodePresentInArray {

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //3217. Delete Nodes From Linked List Present in Array

    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode new_node = new ListNode(0,null);
        ListNode temp = new_node;
        ListNode current = head;
        if(head == null){
            return head;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        while (current != null){
            if(!numSet.contains(current.val)){
                temp.next = new ListNode(current.val,null);
                temp = temp.next;
            }
            current = current.next;
        }

        return new_node.next;
    }
}
