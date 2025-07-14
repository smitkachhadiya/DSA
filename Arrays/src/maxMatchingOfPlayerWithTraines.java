import java.util.Arrays;

public class maxMatchingOfPlayerWithTraines {

    //  2410. Maximum Matching of Players With Trainers

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0 , j = 0;
        int ans = 0;

        while (i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                i++;
                ans++;
            }
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{4,7,9},new int[]{8,2,5,8}));
    }
}
