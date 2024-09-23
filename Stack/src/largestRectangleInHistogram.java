package DSA.dataSets.stack;

import java.util.Stack;

public class largestRectangleInHistogram {
    // 84. Largest Rectangle in Histogram

    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack  = new Stack<>();
        int max=0;
        stack.push(0);

        for(int i=0 ; i < heights.length ; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = getMax(heights,stack,max,i);
            }
            stack.push(i);
        }
        int i = heights.length;
        while (!stack.isEmpty()){
            max = getMax(heights,stack,max,i);
        }
        return max;
    }

    public int getMax(int[] arr, Stack<Integer> stack, int max, int i){
        int area;
        int popped = stack.pop();
        if(stack.empty()){
            area = arr[popped] * i;
        }else{
            area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max,area);
    }


    //
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack  = new Stack<>();
        int max=0;
        stack.push(0);
        int element , pse , nse;
        for(int i=0 ; i < heights.length ; i++){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                element = stack.peek();
                stack.pop();
                nse = i;
                pse = stack.isEmpty() ? -1 : stack.peek();
                max  = Math.max(heights[element] * (nse - pse - 1) , max);
            }
            stack.push(i);
        }
        int i = heights.length;
        while (!stack.isEmpty()){
            nse = heights.length + 1 ;
            element = stack.peek();
            stack.pop();
            pse = stack.isEmpty() ? -1 : stack.peek();
            max  = Math.max(heights[element] * (nse - pse - 1) , max);
        }
        return max;
    }
}
