public class removeLinkListElement {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(0,head);
        ListNode prev = newNode;
        while (prev.next != null ){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return newNode.next;
    }

    //237. Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        while(node.next != null){
            if(node.next.next == null){
                node.val = node.next.val;
                node.next = null;
            }else{
                node.val = node.next.val;
                node= node.next;
            }
        }
    }
}
