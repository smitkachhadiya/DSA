package DSA.Astring;

public class pushDominos {

    // 838. Push Dominoes

    public static String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int lastRight = -1;
        int lastLeft = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if(c == 'R'){
                if (lastRight != -1){
                    for (int j = lastRight + 1; j < i; j++) {
                        arr[j] = 'R';
                    }
                }
                lastRight = i;
            } else if (c == 'L') {
                if(lastRight != -1){
                    int l = lastRight +1;
                    int r = i-1;
                    while (l < r){
                        arr[l++] = 'R';
                        arr[r--] = 'L';
                    }
                    lastRight = -1;
                } else {
                    for (int j = lastLeft; j < i; j++) {
                        arr[j] = 'L';
                    }
                }
                lastLeft = i;
            }
        }

        if (lastRight != -1) {
            for (int i = lastRight + 1; i < n; i++) {
                arr[i] = 'R';
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String sc = ".L.R...LR..L..";
        System.out.println(pushDominoes(sc));
    }
}
