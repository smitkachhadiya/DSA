package DSA.dataSets.linklist;

public class hasCycle {
    class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

    }

    public static boolean checkCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static int cycleLength(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while (temp != slow);
                return length;
            }
        }
        return 0;
    }


    public static ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                length = cycleLength(slow);
                break;
            }
        }

        if(length == 0){
            return null;
        }
        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0){
            s = s.next;
            length--;
        }

        //
        while (f != s){
            f= f.next;
            s=s.next;
        }
        return f;
    }

}
