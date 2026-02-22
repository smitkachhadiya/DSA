public class binaryGap {

    //  868. Binary Gap

    public static int binaryGap(int n) {
        int i=0;
        int count = 0;
        int index = 0;
        int gap = 0;
        while(n!=0){
            if((n&1)==1){
                if(count!=0){
                    gap = Math.max(gap, i-index);
                }
                index = i;
                count++;
            }
            n=n>>1;
            i++;
        }
        return gap;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(15220));
    }
}
