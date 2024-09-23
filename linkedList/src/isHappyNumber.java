package DSA.dataSets.linklist;

public class isHappyNumber {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }


    public int findSquare(int number){
        int ans = 0;
        while (number > 0){
                int rem = number%10;
                ans += rem*rem;
                number /= 10;
        }
        return ans;
    }
}
