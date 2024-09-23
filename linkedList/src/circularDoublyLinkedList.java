
public class circularDoublyLinkedList {

    class MyCircularDeque {
        int val,size;
        MyCircularDeque next;
        MyCircularDeque prev;
        public MyCircularDeque() {}
        public MyCircularDeque(int k) {
            this.val = k;
            size = 0;
        }
        public MyCircularDeque(int val,MyCircularDeque next,MyCircularDeque prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
            size = val;
        }


        MyCircularDeque head = new MyCircularDeque();
        MyCircularDeque tail = new MyCircularDeque();
        public boolean insertFront(int value) {
            if(head == null){
                MyCircularDeque new_node = new MyCircularDeque(value);
                head = new_node;
                return true;
            }
            MyCircularDeque current = head;
            while (current.next != head){
                current = current.next;
            }
            MyCircularDeque new_node = new MyCircularDeque(value);
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            new_node.prev = current;
            current.next = new_node;
            return true;
        }

        public boolean insertLast(int value) {
            if(head == null){
                MyCircularDeque new_node = new MyCircularDeque(value);
                head = new_node;
                return true;
            }
            MyCircularDeque current = head;
            while (current.next != head){
                current = current.next;
            }
            MyCircularDeque new_node = new MyCircularDeque(value);
            new_node.next = head;
            head.prev = new_node;
            new_node.prev = current;
            current.next = new_node;
            return true;
        }

        public boolean deleteFront() {
            MyCircularDeque current = head;
            if(head == null){
                return false;
            }
            if(current.next == head){
                head = null;
                return true;
            }
            while (current.next != head){
                current = current.next;
            }
            head = head.next;
            head.prev = current;
            current.next = head;
            return true;
        }

        public boolean deleteLast() {
            MyCircularDeque current = head;
            MyCircularDeque temp = head;
            if(head == null ){
                return false;
            }
            if(current.next == head){
                head = null;
                return true;
            }
            while (current.next != head){
                current = current.next;
                if(current.next != head){
                    temp = current;
                }
            }
            temp.next = head;
            head.prev = temp;
            return true;
        }

        public int getFront() {
            return head.val;
        }

        public int getRear() {
            MyCircularDeque current = head;
            while (current.next != head){
                current = current.next;
            }
            return current.val;
        }

        public boolean isEmpty() {
            if(head == null){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            int len = 0;
            if(size <= 0 ){
                return true;
            }
            if(head == null){
                return false;
            }
            MyCircularDeque current = head;
            while (current.next != head){
                len++;
                current = current.next;
                if(len > size){
                    return true;
                }
            }
            return false;
        }
    }
}
