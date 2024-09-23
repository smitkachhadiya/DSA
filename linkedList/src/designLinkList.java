package DSA.dataSets.linklist;

public class designLinkList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class MyLinkedList {
        int val;
        MyLinkedList next;
        public MyLinkedList(){}
        public MyLinkedList(int val) {
            this.val = val;
        }
        public MyLinkedList(int val,MyLinkedList next) {
            this.val = val;
            this.next = next;
        }

        public MyLinkedList head = null;

        public int get(int index) {
            MyLinkedList current = head;
            if(head == null){
                return -1;
            }
            int len = 0;
            while (current != null){
                if(len == index){
                    return current.val;
                }
                len++;
                current = current.next;
            }
            return -1;
        }

        public void addAtHead(int val) {
            if(head == null){
                MyLinkedList new_node = new MyLinkedList(val,null);
                head = new_node;
                return;
            }
            MyLinkedList new_node = new MyLinkedList(val,head);
            head = new_node;
        }

        public void addAtTail(int val) {
            if(head == null){
                MyLinkedList new_node = new MyLinkedList(val,null);
                head = new_node;
                return;
            }
            MyLinkedList current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new MyLinkedList(val,null);
        }

        public void addAtIndex(int index, int val) {
            MyLinkedList current = head;
            if (index < 0) {
                return;
            }
            if (index == 0) {
                MyLinkedList new_node = new MyLinkedList(val);
                new_node.next = head;
                head = new_node;
                return;
            }

            int len = 0;
            while (current != null){
                if(len == index-1){
                    MyLinkedList new_node = new MyLinkedList(val,current.next);
                    current.next = new_node;
                    return;
                }
                len++;
                current = current.next;
            }
            if(index == len){
                MyLinkedList new_node = new MyLinkedList(val,null);
                current.next = new_node;
            }
        }

        public void deleteAtIndex(int index) {
            if (head == null) {
                return;
            }
            MyLinkedList current = head;
            if (index == 0) {
                head = head.next;
                return;
            }
            int len = 0;
            while (current != null && current.next !=null){
                if(len == index-1){
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
                len++;
            }
        }

        public void printem(){
            MyLinkedList current = head;
            while (current != null){
                System.out.println(current.val);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.addAtTail(6);
        obj.addAtIndex(1,4);
        obj.deleteAtIndex(2);
        obj.printem();
        System.out.println(obj.get(2));
    }
}
