import java.util.HashSet;
import java.util.Set;

public class minNumOfPeopleToTeach {

    //  1733. Minimum Number of People to Teach

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> people = new HashSet<>();

        for(int[] friends : friendships){
            int u1 = friends[0]-1;
            int u2 = friends[1]-1;
            boolean canCommunicate = false;

            for (int lang1 : languages[u1]){
                for (int lang2 : languages[u2]){
                    if(lang1 == lang2){
                        canCommunicate = true;
                        break;
                    }
                }
                if(canCommunicate){
                    break;
                }
            }
            if(!canCommunicate){
                people.add(u1);
                people.add(u2);
            }
        }

        int ans = languages.length + 1;
        for(int lang = 0 ; lang <= n ; lang++){
            int count = 0;
            for (int user : people){
                boolean know = false;
                for (int l : languages[user]){
                    if(l == lang){
                        know = true;
                        break;
                    }
                }
                if(!know){
                    count++;
                }
            }
            ans = Math.min(ans,count);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumTeachings(2,new int[][]{{1},{2},{1,2}},new int[][]{{1,2},{1,3},{2,3}}));
    }
}
