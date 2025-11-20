import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class populatingNextRightPointersInEachNode {

    //  116. Populating Next Right Pointers in Each Node

    public Node connect(Node root) {
        if (root == null) return null;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;   // left -> right

                if (head.next != null) {
                    head.right.next = head.next.left;   // right → next left
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    //  Using Recursion

    public Node connect2(Node root) {
        if(root==null){
            return null;
        }

        Node left = root.left;
        Node right = root.right;
        Node next = root.next;

        if(left!=null){// means node have both child
            left.next=right;
            if(next!=null){
                right.next=next.left;
            }
            connect2(left);
            connect2(right);
        }

        return root;
    }

    //  Using Level - order Traversal

    public Node connect3(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return root;
        q.offer(root);
        while (!q.isEmpty()){
            List<Node> row = new ArrayList<>();
            int n = q.size();
            for (int i =0; i< n ; i++){
                Node front = q.poll();
                row.add(front);
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
            for (int i = 0; i < row.size()-1; i++) {
                row.get(i).next = row.get(i+1);
            }
            row.get(row.size()-1).next = null;
        }
        return root;
    }
}
