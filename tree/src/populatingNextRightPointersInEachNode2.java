import java.util.LinkedList;
import java.util.Queue;

public class populatingNextRightPointersInEachNode2 {

    //  117. Populating Next Right Pointers in Each Node II

    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);
            Node tail = dummy;
            while (head != null) {
                if (head.left != null) {
                    tail.next = head.left;
                    tail = tail.next;
                }
                if (head.right != null) {
                    tail.next = head.right;
                    tail = tail.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }

    //  Using Queue

    public Node connect2(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return root;
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            for (int i =0; i< n ; i++){
                Node front = q.poll();
                if (i < n - 1) front.next = q.peek();
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
        }
        return root;
    }
}
