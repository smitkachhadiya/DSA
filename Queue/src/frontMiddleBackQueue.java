import java.util.*;

public class frontMiddleBackQueue {
    // 1670. Design Front Middle Back Queue


    // error
    static class FrontMiddleBackQueue {

        private ArrayDeque<Integer> front;
        private ArrayDeque<Integer> back;

        public FrontMiddleBackQueue() {
            front = new ArrayDeque<>();
            back = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            front.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            // Add to front if front is larger than back
            if (front.size() <= back.size()) {
                front.addLast(back.removeFirst()); // Move one element from back to front
            }
            front.addLast(val);
            balance();
        }

        public void pushBack(int val) {
            back.addLast(val);
            balance();
        }

        public int popFront() {
            if (front.isEmpty()) {
                return -1;
            }
            int result = front.removeFirst();
            balance();
            return result;
        }

        public int popMiddle() {
            if (front.isEmpty() && back.isEmpty()) {
                return -1;
            }

            int result;
            if (front.size() >= back.size()) {
                result = front.removeLast(); // Remove from front if it has equal or more
            } else {
                result = back.removeFirst();
            }

            balance();
            return result;
        }

        public int popBack() {
            if (back.isEmpty()) {
                return -1;
            }
            int result = back.removeLast();
            balance();
            return result;
        }

        private void balance() {
            // Ensure front has at most one more element than back
            if (front.size() > back.size() + 1) {
                back.addFirst(front.removeLast());
            } else if (back.size() > front.size()) {
                front.addLast(back.removeFirst());
            }
        }
    }


    public static void main(String[] args) {
        FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
        obj.pushFront(4);
        obj.pushMiddle(6);
        obj.pushBack(3);
        int param_4 = obj.popFront();
        int param_5 = obj.popMiddle();
        int param_6 = obj.popBack();

        Queue<Integer> q = new PriorityQueue<>();
    }
}
