

public class timeToBuyTickets {
    // 2073. Time Needed to Buy Tickets
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(i <= k){
                if(tickets[i] <= tickets[k]){
                    sum += tickets[i];
                }else {
                    sum += tickets[k];
                }
            }else{
                if(tickets[i] < tickets[k]){
                    sum += tickets[i];
                }else {
                    sum += tickets[k] -1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        int k = 3;
        System.out.println(timeRequiredToBuy(tickets,k));
    }
}
