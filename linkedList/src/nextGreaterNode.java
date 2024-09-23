package DSA.dataSets.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nextGreaterNode {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int n=0;
        while (temp != null){
            n++;
            list.add(temp.val);
            temp = temp.next;
        }

        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<n ;i++){
            while (!stack.empty() && list.get(i) > list.get(stack.peek())){
                int index = stack.pop();
                result[index] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
