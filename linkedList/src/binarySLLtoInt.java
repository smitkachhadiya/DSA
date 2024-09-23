

public class binarySLLtoInt {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    //1290. Convert Binary Number in a Linked List to Integer
    public int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head!=null){
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }

    // Other Solution
    public int getDecimalValue2(ListNode head) {
        int ans = 0;
        ListNode temp = head;
        int n = checkLength(head);
        for (int i= n ; i > 0; i--){
            if(temp.val == 1){
                ans += Math.pow(2,i-1);
            }
            temp = temp.next;
        }
        return ans;
    }

    int checkLength(ListNode temp){
        int len =0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
