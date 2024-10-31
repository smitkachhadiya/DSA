public class singlyLinkList {

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void insertAtFirst(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            tail = new_node;
        }else {
            tail.next = new_node;
            tail = new_node;
        }
    }

    public void display(){
        Node current = head;
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        while (current != null){
            System.out.print(current.data);
            if(current.next != null){
                System.out.print(" -> ");
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        singlyLinkList sll = new singlyLinkList();
        sll.insertAtFirst(1);
        sll.insertAtFirst(3);
        sll.insertAtFirst(5);
        sll.insertAtFirst(2);

        sll.display();

    }
}
