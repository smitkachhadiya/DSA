package DSA.dataSets.linklist;

public class palindromSLL {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // 234. Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMiddle(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        while (head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);
        return  headSecond==null;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        while (current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    public ListNode getMiddle(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }


    // Method - 2:

    public boolean isPalindrome2(ListNode head) {
        ListNode temp = head;
        String demo = "";
        while (temp!= null){
            demo += temp.val;
            temp = temp.next;
        }
        String rev = "";
        for(char ch : demo.toCharArray()){
            rev = ch + rev;
        }
        return demo.equals(rev);
    }

}
